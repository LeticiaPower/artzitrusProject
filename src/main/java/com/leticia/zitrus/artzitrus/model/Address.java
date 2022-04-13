package com.leticia.zitrus.artzitrus.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @NotNull
    private String zipCode;

    @NotNull
    private String logradouro;

    @NotNull
    private String complement;

    private String district;

    private String city;

    @NotNull
    private String fu;

}
