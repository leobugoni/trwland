package io.github.leobugoni.trwland.customer.repository;


import io.github.leobugoni.trwland.customer.factory.CustomerEntityFactory;
import io.github.leobugoni.trwland.customer.respository.CustomerRepository;
import io.github.leobugoni.trwland.customer.respository.exception.CustomerNotFoundException;
import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;
import io.github.leobugoni.trwland.customer.respository.repositories.CustomerEntityRepository;
import io.github.leobugoni.trwland.customer.respository.repositories.impl.CustomerRepositoryImpl;
import org.jeasy.random.EasyRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CustomerRepositoryImpl.class})
public class CustomerEntityRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @MockBean
    private CustomerEntityRepository customerEntityRepository;

    private final EasyRandom random = new EasyRandom();

    @Test
    public void mustSuccessCreateCustomer(){
        customerRepository.saveCustomer(random.nextObject(CustomerEntity.class));
        Mockito.verify(customerEntityRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void mustSuccessUpdateCustomer(){
        Mockito.when(customerEntityRepository.save(Mockito.any()))
                .thenReturn(CustomerEntityFactory.buildCustomerEntity(1L));
        Mockito.when(customerEntityRepository.existsById(Mockito.anyLong())).thenReturn(true);
        customerRepository.updateCustomer(random.nextObject(CustomerEntity.class));
        Mockito.verify(customerEntityRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test(expected = CustomerNotFoundException.class)
    public void mustFailureUpdateCustomer(){
        Mockito.when(customerEntityRepository.existsById(Mockito.anyLong())).thenReturn(false);
        customerRepository.updateCustomer(CustomerEntityFactory.buildCustomerEntity(1L));
    }

    @Test
    public void mustSuccessFindCustomer(){
        Mockito.when(customerEntityRepository.findById(1L))
                .thenReturn(Optional.of(CustomerEntityFactory.buildCustomerEntity(1L)));
        customerRepository.findCustomer(1L);
        Mockito.verify(customerEntityRepository, Mockito.times(1)).findById(Mockito.any());
    }

}
