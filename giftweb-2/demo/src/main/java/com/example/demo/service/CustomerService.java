
package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;
@Service
public class CustomerService 
{
    
    @Autowired
    private CustomerRepo customerRepo;

    public Customer save(Customer customer)
    {
           return customerRepo.save(customer);
    }

    public List<Customer> getCustomer()
    {
        return customerRepo.findAll();
    }
}