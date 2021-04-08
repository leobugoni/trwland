package io.github.leobugoni.trwland.customer.factory;

import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomerEntityFactory {

    public static CustomerEntity buildCustomerEntity(final Long customerId){
        return CustomerEntity.builder()
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
