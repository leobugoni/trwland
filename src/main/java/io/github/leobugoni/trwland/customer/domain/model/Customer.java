package io.github.leobugoni.trwland.customer.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String firstName;
    private String lastName;
    private String age;
    private String emailAddress;
    private String phone;
    private Set<Document> documents;
    private Set<Address> addresses;

}
