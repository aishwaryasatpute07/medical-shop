package com.medicalshop.medical_shop_project.controller;

import com.medicalshop.medical_shop_project.model.CustomerDTO;
import com.medicalshop.medical_shop_project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long c_id) {
        Optional<CustomerDTO> customer = customerService.getCustomerById(c_id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long c_id, @RequestBody CustomerDTO customerDTO) {
        try {
            CustomerDTO updateCustomer = customerService.updateCustomer(c_id, customerDTO);
            return ResponseEntity.ok(updateCustomer);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long c_id) {
        customerService.deleteCustomer(c_id);
        return ResponseEntity.noContent().build();
    }
}
