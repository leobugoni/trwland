package io.github.leobugoni.trwland.customer.respository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "addresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Long id;
    private String street;
    private String city;
    private String zipCode;
    private String state;
    private String country;
}
