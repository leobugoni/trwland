package io.github.leobugoni.trwland.customer.adapter.api.server;


import io.github.leobugoni.trwland.customer.domain.model.Customer;
import io.github.leobugoni.trwland.customer.factory.CustomerEntityFactory;
import io.github.leobugoni.trwland.customer.factory.CustomerFactory;
import io.github.leobugoni.trwland.customer.respository.CustomerRepository;
import org.jeasy.random.EasyRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CustomerController.class})
public class CustomerControllerTest {

    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerRepository customerRepository;

    private final EasyRandom random = new EasyRandom();

    @Test
    public void mustSuccessCreateCustomer(){
        customerController.createCustomer(CustomerFactory.buildCustomer(1L));
        Mockito.verify(customerRepository, Mockito.times(1)).saveCustomer(any());
    }

    @Test
    public void mustSuccessFindCustomer(){
        Long customerId = 1L;
        Mockito.when(customerRepository.findCustomer(customerId))
                .thenReturn(CustomerEntityFactory.buildCustomerEntity(customerId));
        customerController.findCustomer(customerId);
        Mockito.verify(customerRepository, Mockito.times(1)).findCustomer(any());
    }

    @Test
    public void mustSuccessUpdateCustomer(){
        final Customer customer = CustomerFactory.buildCustomer(1L);
        customerController.updateCustomer(customer);
        Mockito.verify(customerRepository, Mockito.times(1)).updateCustomer(any());
    }

}
