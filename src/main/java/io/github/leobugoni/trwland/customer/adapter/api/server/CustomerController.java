package io.github.leobugoni.trwland.customer.adapter.api.server;

import io.github.leobugoni.trwland.customer.domain.mapper.CustomerMapper;
import io.github.leobugoni.trwland.customer.domain.model.Customer;
import io.github.leobugoni.trwland.customer.respository.CustomerRepository;
import io.github.leobugoni.trwland.customer.respository.mapper.CustomerEntityMapper;
import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PostMapping(path = "/", consumes = "application/json")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer){
        customerRepository.saveCustomer(CustomerMapper.toCustomerEntity(customer));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/", consumes = "application/json")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer){
        customerRepository.updateCustomer(CustomerMapper.toCustomerEntity(customer));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/{customer_id}", produces = "application/json")
    public ResponseEntity<Object> findCustomer(@PathVariable(value = "customer_id") Long customerId){
        return ResponseEntity.status(HttpStatus.OK).body(
                CustomerEntityMapper.toCustomer(
                        customerRepository.findCustomer(customerId)
                )
        );
    }
}
