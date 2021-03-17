package io.github.leobugoni.trwland.customer.adapter.api.server;

import io.github.leobugoni.trwland.customer.domain.mapper.CustomerMapper;
import io.github.leobugoni.trwland.customer.domain.model.Customer;
import io.github.leobugoni.trwland.customer.respository.CustomerRepository;
import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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

}
