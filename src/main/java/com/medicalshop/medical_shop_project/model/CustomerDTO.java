package com.medicalshop.medical_shop_project.model;

public record CustomerDTO(Long id, String name, String email, String password, String address, Role role) {
}
