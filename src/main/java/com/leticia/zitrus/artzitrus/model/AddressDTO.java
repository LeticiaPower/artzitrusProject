package com.leticia.zitrus.artzitrus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDTO {

    private Long id;
    private String zipCode;
    private String logradouro;
    private String complement;
    private String district;
    private String city;
    private String fu;
}
