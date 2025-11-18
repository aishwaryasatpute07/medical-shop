package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Customer;
import com.medicalshop.medical_shop_project.model.CustomerDTO;
import com.medicalshop.medical_shop_project.model.User;
import com.medicalshop.medical_shop_project.repository.CustomerRepository;
import com.medicalshop.medical_shop_project.repository.UserRepository;
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
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = convertToEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);

        String email = customer.getC_email();
        String password = customer.getC_password();
        String username = customer.getC_name();
        Long u_id = customer.getC_id();
        Boolean isCustomer = true;

        User userCustomer = new User(email, password, username ,"","",u_id, isCustomer);

        if(customer.getUser())
        {
            User savedUser = userRepository.save(userCustomer);
        }

        return convertToDTO(savedCustomer);
    }


    @Override
    public CustomerDTO updateCustomer(Long c_id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(c_id).orElseThrow();
        customer.setC_name(customerDTO.c_name());
        customer.setC_address(customerDTO.c_address());
        Customer updatedCustomer = customerRepository.save(customer);
        return convertToDTO(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long c_id) {
        customerRepository.deleteById(c_id);
    }

    //Conversion methods between DTO and Entity
    private CustomerDTO convertToDTO(Customer customer) {
        return new CustomerDTO(customer.getC_id(), customer.getC_name(), customer.getC_email(), customer.getC_password(), customer.getC_address(), customer.getUser());
    }

    private Customer convertToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setC_name(customerDTO.c_name());
        customer.setC_address(customerDTO.c_address());
        return customer;
    }
}
