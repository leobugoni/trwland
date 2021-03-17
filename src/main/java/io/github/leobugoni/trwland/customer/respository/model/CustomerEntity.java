package io.github.leobugoni.trwland.customer.respository.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String age;
    private String emailAddress;
    private String phone;
    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private Set<DocumentEntity> documents;
    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private Set<AddressEntity> addresses;

}
