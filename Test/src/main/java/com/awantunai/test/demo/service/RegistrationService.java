package com.awantunai.test.demo.service;

import com.awantunai.test.demo.model.dto.UserRegisterRequest;
import com.awantunai.test.demo.model.entity.User;
import com.awantunai.test.demo.repository.UserRepository;
import com.awantunai.test.demo.util.EncryptUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegistrationService {

    private final UserRepository userRepository;

    public ResponseEntity register(UserRegisterRequest userRegisterRequest) {
        Optional<User> existingUser = userRepository.findByEmailAddress(userRegisterRequest.getEmailAddress());

        if (existingUser.isPresent()) {
            throw new RestClientException("user already registered");
        }

        if (!userRegisterRequest.getPassword().equals(userRegisterRequest.getConfirmPassword())) {
            throw new RestClientException("Password dont match");
        }

        User user = User.builder()
                .emailAddress(userRegisterRequest.getEmailAddress())
                .fullName(userRegisterRequest.getFullName())
                .password(EncryptUtil.encrypt(userRegisterRequest.getPassword()))
                .build();

        userRepository.save(user);
    }

}
