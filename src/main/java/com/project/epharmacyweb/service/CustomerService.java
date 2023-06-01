package com.project.epharmacyweb.service;

import com.project.epharmacyweb.entity.Customer;
import com.project.epharmacyweb.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer student) {
        return customerRepository.save(student);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    public Customer updateCustomer(Customer student) {
        return customerRepository.save(student);
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

}
