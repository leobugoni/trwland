package io.github.leobugoni.trwland.customer.factory;

import io.github.leobugoni.trwland.customer.domain.model.Customer;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class CustomerFactory {

    public static Customer buildCustomer(final Long customerId){
        return Customer.builder()
                .id(customerId)
                .firstName("Osvaldo")
                .lastName("Campos")
                .age("69")
                .document("12031398024")
                .emailAddress("osvaldovictorcampos-78@pciinformatica.com")
                .phone("85988712779")
                .build();
    }
}
