package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Customer;
import com.medicalshop.medical_shop_project.model.enums.Role;
import com.medicalshop.medical_shop_project.model.User;
import com.medicalshop.medical_shop_project.model.UserDTO;
import com.medicalshop.medical_shop_project.repository.CustomerRepository;
import com.medicalshop.medical_shop_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getUserById(Long u_id) {
        return userRepository.findById((u_id)).map(this::convertToDTO);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);

        Long customerId = user.getId();
        String customerName = user.getFirstname();
        String customerEmail = user.getEmail();
        String customerPassword = user.getPassword();
        Role role = Role.USER;
        Boolean isUser = true;
        Customer customerUser = new Customer(customerId, customerName, customerEmail, customerPassword, "", role);

        if (user.getIsCustomer()) {
            Customer savedCustomer = customerRepository.save(customerUser);
        }

        return convertToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long u_id, UserDTO userDTO) {
        User user = userRepository.findById(u_id).orElseThrow();
        user.setFirstname(userDTO.u_firstName());
        user.setLastname(userDTO.u_lastName());
        user.setEmail(userDTO.email());
        User updatedUser = userRepository.save(user);
        return convertToDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long u_id) {
        userRepository.deleteById(u_id);
    }

    //Conversion methods between DTO and Entity
    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword(),
                user.getEmail(), user.getIsCustomer());
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setFirstname(userDTO.u_firstName());
        user.setLastname(userDTO.u_lastName());
        user.setEmail(userDTO.email());
        return user;
    }
}
