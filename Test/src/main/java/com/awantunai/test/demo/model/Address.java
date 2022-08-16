package com.awantunai.test.demo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private String line1;
    private String line2;
    private String city;
    private String postalCode;
}
