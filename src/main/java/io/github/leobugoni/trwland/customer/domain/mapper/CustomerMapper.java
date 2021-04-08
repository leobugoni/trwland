package io.github.leobugoni.trwland.customer.domain.mapper;

import io.github.leobugoni.trwland.customer.domain.model.Customer;
import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomerMapper {


    public static CustomerEntity toCustomerEntity(Customer customer){
        return CustomerEntity.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .age(customer.getAge())
                .document(customer.getDocument())
                .emailAddress(customer.getEmailAddress())
                .phone(customer.getPhone())
                .build();
    }
}
