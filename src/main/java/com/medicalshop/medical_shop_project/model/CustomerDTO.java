package com.medicalshop.medical_shop_project.model;

import com.medicalshop.medical_shop_project.model.enums.Role;

public record CustomerDTO(Long id, String name, String email, String password, String address, Role role) {
}
