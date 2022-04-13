package com.leticia.zitrus.artzitrus.controller;

import com.leticia.zitrus.artzitrus.model.Address;
import com.leticia.zitrus.artzitrus.model.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class AddressController {

    @Autowired
    private AddressRepository repository;

    @RequestMapping("/customers/address/search/{zipCode}")
    @ResponseBody
    public Object searchAddressByZipCode(@PathVariable(value="zipCode") String zipCode) {
        String urlOpenCep = "https://opencep.com/v1/" + zipCode;
        RestTemplate restTemplate = new RestTemplate();
        Object address = restTemplate.getForObject(urlOpenCep, Object.class);

        return address;
    }

    @GetMapping("/customers/address/{id}")
    public String getAddress(@PathVariable("id") long id, Model model) {
        Optional<Address> optionalAddress = repository.findById(id);
        if (!optionalAddress.isPresent()) {
            throw new IllegalArgumentException("Endereço não encontrado.");
        }
        model.addAttribute("address", optionalAddress.get());

        return "customers/details";
    }
}
