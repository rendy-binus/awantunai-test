package com.awantunai.test.demo.model.entity;

import com.awantunai.test.demo.model.Address;
import com.awantunai.test.demo.model.UserGender;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User extends BaseEntity {

    @Column(unique = true)
    private String emailAddress;

    private String fullName;

    private String password;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Address address;

    private UserGender gender;
}
