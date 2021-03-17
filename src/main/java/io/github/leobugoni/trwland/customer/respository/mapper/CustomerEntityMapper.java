package io.github.leobugoni.trwland.customer.respository.mapper;

import io.github.leobugoni.trwland.customer.domain.model.Address;
import io.github.leobugoni.trwland.customer.domain.model.Customer;
import io.github.leobugoni.trwland.customer.domain.model.Document;
import io.github.leobugoni.trwland.customer.domain.model.DocumentType;
import io.github.leobugoni.trwland.customer.respository.model.AddressEntity;
import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;
import io.github.leobugoni.trwland.customer.respository.model.DocumentEntity;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class CustomerEntityMapper {

    public static Customer toCustomer(CustomerEntity customerEntity){
        return Customer.builder()
                .id(customerEntity.getId())
                .firstName(customerEntity.getFirstName())
                .lastName(customerEntity.getLastName())
                .age(customerEntity.getAge())
                .emailAddress(customerEntity.getEmailAddress())
                .phone(customerEntity.getPhone())
                .addresses(toAddressList(customerEntity.getAddresses()))
                .documents(toDocumentList(customerEntity.getDocuments()))
                .build();
    }

    private static Set<Address> toAddressList(Set<AddressEntity> addressEntities){
        return addressEntities.stream()
                .map(CustomerEntityMapper::toAddress)
                .collect(Collectors.toSet());
    }

    private static Address toAddress(AddressEntity addressEntity){
        return Address.builder()
                .city(addressEntity.getCity())
                .country(addressEntity.getCountry())
                .state(addressEntity.getState())
                .street(addressEntity.getStreet())
                .zipCode(addressEntity.getZipCode())
                .build();
    }

    private static Set<Document> toDocumentList(Set<DocumentEntity> documentEntities){
        return documentEntities.stream()
                .map(CustomerEntityMapper::toDocument)
                .collect(Collectors.toSet());
    }

    private static Document toDocument(DocumentEntity documentEntity){
        return Document.builder()
                .number(documentEntity.getNumber())
                .documentType(DocumentType.valueOf(documentEntity.getDocumentType().toString()))
                .build();
    }
}
