package com.algaworks.examplerestapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.algaworks.examplerestapi.model.Customer;
import com.algaworks.examplerestapi.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository cr;

    @GetMapping
    public List<Customer> list() {
        return cr.findAll();
    }

    @PostMapping
    public Customer add(@RequestBody @Valid Customer customer) {
        return cr.save(customer);
    }

    @DeleteMapping
    public Customer delete(@RequestBody Customer customer) {
        cr.delete(customer);

        return customer;
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") long id) {
        return cr.getById(id);
    }
}
