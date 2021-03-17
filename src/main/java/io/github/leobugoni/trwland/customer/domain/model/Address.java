package io.github.leobugoni.trwland.customer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String city;
    private String zipCode;
    private String state;
    private String country;
}
