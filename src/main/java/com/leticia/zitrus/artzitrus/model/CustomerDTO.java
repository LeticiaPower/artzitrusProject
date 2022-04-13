package com.leticia.zitrus.artzitrus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private Long id;
    private String name;
    private String cpf;
    private Long number;
    private AddressDTO address;

    public CustomerDTO(Long id, String name, String cpf, Long number, Long addressId, String zipCode, String logradouro,
                       String complement, String district, String city, String fu) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.number = number;
        this.address = new AddressDTO(addressId, zipCode, logradouro, complement, district, city, fu);
    }

}
