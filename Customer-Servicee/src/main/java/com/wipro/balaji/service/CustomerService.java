package com.wipro.balaji.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.wipro.balaji.entity.Customer;

@Service
public interface CustomerService {

    Customer createCustomer(Customer customer);
    Customer getCustomerById(Long id);
    Page<Customer> getAllCustomers(Pageable pageable);
    void deleteCustomerById(Long id);
    Customer patchCustomerById(Long id, Customer customer);

}
