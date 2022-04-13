package com.leticia.zitrus.artzitrus.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @CPF
    private String cpf;

    @Column(length = 12)
    private Long number;

    @ManyToOne(optional = false, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="address_id", nullable=false)
    private Address address;
}
