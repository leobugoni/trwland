package io.github.leobugoni.trwland.customer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    private String number;
    private DocumentType documentType;

}
