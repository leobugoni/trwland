package io.github.leobugoni.trwland.customer.respository.repositories.impl;

import io.github.leobugoni.trwland.customer.respository.CustomerRepository;
import io.github.leobugoni.trwland.customer.respository.exception.CustomerNotFoundException;
import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;
import io.github.leobugoni.trwland.customer.respository.repositories.CustomerEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerEntityRepository customerRepository;

    @Override
    public void saveCustomer(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity findCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public void updateCustomer(CustomerEntity customer) {
        if (customerRepository.existsById(customer.getId())) {
            customerRepository.save(customer);
        } else {
            throw new CustomerNotFoundException(customer.getId());
        }
    }
}
