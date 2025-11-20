package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Customer;
import com.medicalshop.medical_shop_project.model.CustomerDTO;
import com.medicalshop.medical_shop_project.model.User;
import com.medicalshop.medical_shop_project.repository.CustomerRepository;
import com.medicalshop.medical_shop_project.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(Long c_id) {
        return customerRepository.findById((c_id)).map(this::convertToDTO);
    }

    @Override
    public Customer saveCustomer(Customer customerDTO) {
        // Check if email already exists
        if (customerRepository.existsByEmail(customerDTO.getEmail())) {
            throw new RuntimeException("Email already exists: " + customerDTO.getEmail());
        }

        Customer saved = customerRepository.save(customerDTO);
        return customerDTO;
    }


    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setName(customerDTO.name());
        customer.setAddress(customerDTO.address());
        Customer updatedCustomer = customerRepository.save(customer);
        return convertToDTO(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO authenticateCustomer(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
    }

    //Conversion methods between DTO and Entity
    private CustomerDTO convertToDTO(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail(), customer.getPassword(), customer.getAddress(), customer.getRole());
    }

    private Customer convertToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.name());
        customer.setAddress(customerDTO.address());
        customer.setEmail(customerDTO.email());
        customer.setPassword(customerDTO.password());
        customer.setRole(customerDTO.role());
        return customer;
    }
}
