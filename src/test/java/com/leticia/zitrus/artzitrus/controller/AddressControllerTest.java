package com.leticia.zitrus.artzitrus.controller;

import com.leticia.zitrus.artzitrus.model.Address;
import com.leticia.zitrus.artzitrus.model.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AddressRepository addressRepository;

    @Test
    @WithMockUser
    public void canReturnAddressByIdWhenExists() throws Exception {
        Address address = new Address(1l, "72222222", "Street Test", "number 2",
                "neibor", "TestCity", "BR");
        when(addressRepository.findById(1l)).thenReturn(Optional.of(address));

        this.mvc.perform(MockMvcRequestBuilders.get("/customers/address/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("customers/details"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("address"));
    }
}