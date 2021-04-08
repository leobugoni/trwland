package io.github.leobugoni.trwland.customer.respository.mapper;

import io.github.leobugoni.trwland.customer.domain.model.Customer;
import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomerEntityMapper {

    public static Customer toCustomer(CustomerEntity customerEntity){
        return Customer.builder()
                .id(customerEntity.getId())
                .firstName(customerEntity.getFirstName())
                .lastName(customerEntity.getLastName())
                .age(customerEntity.getAge())
                .document(customerEntity.getDocument())
                .emailAddress(customerEntity.getEmailAddress())
                .phone(customerEntity.getPhone())
                .build();
    }
}
