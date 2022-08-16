package com.awantunai.test.demo.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterRequest {
    private String emailAddress;
    private String fullName;
    private String password;
    private String confirmPassword;
}
