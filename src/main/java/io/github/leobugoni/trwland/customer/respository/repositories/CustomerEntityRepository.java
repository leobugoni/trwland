package io.github.leobugoni.trwland.customer.respository.repositories;

import io.github.leobugoni.trwland.customer.respository.model.CustomerEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
public interface CustomerEntityRepository extends CrudRepository<CustomerEntity, Long> {}
