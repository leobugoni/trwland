package io.github.leobugoni.trwland.customer.respository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String document;
    private String age;
    private String emailAddress;
    private String phone;
}
