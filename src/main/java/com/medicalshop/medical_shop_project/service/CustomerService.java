package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    Optional<CustomerDTO> getCustomerById(Long c_id);

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(Long c_id, CustomerDTO customerDTO);

    void deleteCustomer(Long c_id);
}