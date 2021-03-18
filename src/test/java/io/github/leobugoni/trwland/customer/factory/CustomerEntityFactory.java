package io.github.leobugoni.trwland.customer.factory;

import io.github.leobugoni.trwland.customer.domain.model.Address;
import io.github.leobugoni.trwland.customer.domain.model.Document;
import io.github.leobugoni.trwland.customer.respository.model.AddressEntity;
import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;
import io.github.leobugoni.trwland.customer.respository.model.DocumentEntity;
import io.github.leobugoni.trwland.customer.respository.model.DocumentTypeEntity;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class CustomerEntityFactory {

    public static CustomerEntity buildCustomerEntity(final Long customerId){
        return CustomerEntity.builder()
                .id(customerId)
                .firstName("Osvaldo")
                .lastName("Campos")
                .age("69")
                .emailAddress("osvaldovictorcampos-78@pciinformatica.com")
                .phone("85988712779")
                .addresses(toAddressEntityList(new HashSet<>()))
                .documents(toDocumentEntityList(new HashSet<>()))
                .build();
    }

    private static Set<AddressEntity> toAddressEntityList(Set<Address> address){
        return address.stream()
                .map(CustomerEntityFactory::toAddressEntity)
                .collect(Collectors.toSet());
    }

    private static AddressEntity toAddressEntity(Address address){
        return AddressEntity.builder()
                .city("Fortaleza")
                .country("Brasil")
                .state("Ceará")
                .street("Rua Sol Poente")
                .zipCode("60766660")
                .build();
    }

    private static Set<DocumentEntity> toDocumentEntityList(Set<Document> documents){
        return documents.stream()
                .map(CustomerEntityFactory::toDocumentEntity)
                .collect(Collectors.toSet());
    }

    private static DocumentEntity toDocumentEntity(Document document){
        return DocumentEntity.builder()
                .number("55208677989")
                .documentType(DocumentTypeEntity.CPF)
                .build();
    }
}
