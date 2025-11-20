package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Customer;
import com.medicalshop.medical_shop_project.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    Optional<CustomerDTO> getCustomerById(Long id);

    Customer saveCustomer(Customer customerDTO);

    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomer(Long id);

    CustomerDTO authenticateCustomer(String email, String password);

}