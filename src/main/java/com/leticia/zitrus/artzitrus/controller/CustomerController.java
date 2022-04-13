package com.leticia.zitrus.artzitrus.controller;

import com.leticia.zitrus.artzitrus.model.Customer;
import com.leticia.zitrus.artzitrus.model.CustomerDTO;
import com.leticia.zitrus.artzitrus.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customers/index")
    public String getCustomers(Model model) {
        List<CustomerDTO> customers = repository.findAllCustomers();
        model.addAttribute("listCustomers", customers);

        return "customers/index";
    }

    @GetMapping("/customers/new")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());

        return "customers/form";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customers/form";
        }

        repository.save(customer);
        return "redirect:/customers/index";
    }

    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable("id") long id) {
        Optional<Customer> optionalCustomer = repository.findById(id);
        if (!optionalCustomer.isPresent()) {
            throw new IllegalArgumentException("Cliente inválido.");
        }

        repository.delete(optionalCustomer.get());
        return "redirect:/customers/index";
    }

}
