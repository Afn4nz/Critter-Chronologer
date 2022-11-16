package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
     return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

}
