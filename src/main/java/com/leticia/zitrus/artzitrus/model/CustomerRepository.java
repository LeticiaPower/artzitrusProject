package com.leticia.zitrus.artzitrus.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select new com.leticia.zitrus.artzitrus.model.CustomerDTO(c.id, c.name, c.cpf, c.number, a.id, a.zipCode, " +
            "a.logradouro, a.complement, a.district, a.city, a.fu) from Customer c left join c.address a")
    List<CustomerDTO> findAllCustomers();
}

