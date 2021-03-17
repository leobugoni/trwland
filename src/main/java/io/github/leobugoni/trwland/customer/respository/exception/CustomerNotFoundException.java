package io.github.leobugoni.trwland.customer.respository.exception;

import static java.lang.String.format;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long customerId) {
        super(format("Customer ID %s not found", customerId.toString()));
    }
}
