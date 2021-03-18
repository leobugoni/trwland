package io.github.leobugoni.trwland.customer.factory;

import io.github.leobugoni.trwland.customer.domain.model.Address;
import io.github.leobugoni.trwland.customer.domain.model.Document;
import io.github.leobugoni.trwland.customer.domain.model.Address;
import io.github.leobugoni.trwland.customer.domain.model.Customer;
import io.github.leobugoni.trwland.customer.domain.model.Document;
import io.github.leobugoni.trwland.customer.domain.model.DocumentType;
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
                .emailAddress("osvaldovictorcampos-78@pciinformatica.com")
                .phone("85988712779")
                .addresses(toAddressList(new HashSet<>()))
                .documents(toDocumentList(new HashSet<>()))
                .build();
    }

    private static Set<Address> toAddressList(Set<Address> address){
        return address.stream()
                .map(CustomerFactory::toAddress)
                .collect(Collectors.toSet());
    }

    private static Address toAddress(Address address){
        return Address.builder()
                .city("Fortaleza")
                .country("Brasil")
                .state("Ceará")
                .street("Rua Sol Poente")
                .zipCode("60766660")
                .build();
    }

    private static Set<Document> toDocumentList(Set<Document> documents){
        return documents.stream()
                .map(CustomerFactory::toDocument)
                .collect(Collectors.toSet());
    }

    private static Document toDocument(Document document){
        return Document.builder()
                .number("55208677989")
                .documentType(DocumentType.CPF)
                .build();
    }
}
