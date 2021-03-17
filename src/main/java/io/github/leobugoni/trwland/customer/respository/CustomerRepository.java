package io.github.leobugoni.trwland.customer.respository;

import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;

public interface CustomerRepository {

    void saveCustomer(CustomerEntity customer);
    CustomerEntity findCustomer(Long id);
}
