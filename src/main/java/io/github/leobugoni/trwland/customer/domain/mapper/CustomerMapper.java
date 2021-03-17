package io.github.leobugoni.trwland.customer.domain.mapper;

import io.github.leobugoni.trwland.customer.domain.model.Address;
import io.github.leobugoni.trwland.customer.domain.model.Customer;
import io.github.leobugoni.trwland.customer.domain.model.Document;
import io.github.leobugoni.trwland.customer.respository.model.AddressEntity;
import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;
import io.github.leobugoni.trwland.customer.respository.model.DocumentEntity;
import io.github.leobugoni.trwland.customer.respository.model.DocumentTypeEntity;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class CustomerMapper {


    public static CustomerEntity toCustomerEntity(Customer customer){
        return CustomerEntity.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .age(customer.getAge())
                .emailAddress(customer.getEmailAddress())
                .phone(customer.getPhone())
                .addresses(toAddressEntityList(customer.getAddresses()))
                .documents(toDocumentEntityList(customer.getDocuments()))
                .build();
    }

    private static Set<AddressEntity> toAddressEntityList(Set<Address> address){
        return address.stream()
                .map(CustomerMapper::toAddressEntity)
                .collect(Collectors.toSet());
    }

    private static AddressEntity toAddressEntity(Address address){
        return AddressEntity.builder()
                .city(address.getCity())
                .country(address.getCountry())
                .state(address.getState())
                .street(address.getStreet())
                .zipCode(address.getZipCode())
                .build();
    }

    private static Set<DocumentEntity> toDocumentEntityList(Set<Document> documents){
        return documents.stream()
                .map(CustomerMapper::toDocumentEntity)
                .collect(Collectors.toSet());
    }

    private static DocumentEntity toDocumentEntity(Document document){
        return DocumentEntity.builder()
                .number(document.getNumber())
                .documentType(DocumentTypeEntity.valueOf(document.getDocumentType().toString()))
                .build();
    }
}
