package com.medicalshop.medical_shop_project.controller;

import com.medicalshop.medical_shop_project.model.UserDTO;
import com.medicalshop.medical_shop_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long u_id) {
        Optional<UserDTO> user = userService.getUserById(u_id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long u_id, @RequestBody UserDTO userDTO) {
        try {
            UserDTO updateUser = userService.updateUser(u_id, userDTO);
            return ResponseEntity.ok(updateUser);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long u_id) {
        userService.deleteUser(u_id);
        return ResponseEntity.noContent().build();
    }
}
