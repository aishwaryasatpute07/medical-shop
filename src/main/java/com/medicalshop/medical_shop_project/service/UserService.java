package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUserById(Long u_id);

    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(Long u_id, UserDTO userDTO);

    void deleteUser(Long u_id);
}
