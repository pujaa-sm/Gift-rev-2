
package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
     
    @PostMapping("/customer")
    public Customer create(@RequestBody Customer customer)
    {
        return customerService.save(customer);
    }


    
    @GetMapping("/customer")
    public List<Customer> getCustomer()
    {
        return customerService.getCustomer();
    }

    
}