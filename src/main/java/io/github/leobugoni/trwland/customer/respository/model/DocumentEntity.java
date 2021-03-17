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
@Entity(name = "documents")
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Long id;
    private String number;
    private DocumentTypeEntity documentType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}
