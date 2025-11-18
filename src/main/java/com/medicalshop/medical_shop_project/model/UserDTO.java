package com.medicalshop.medical_shop_project.model;

public record UserDTO(Long u_id, String u_firstName, String u_lastName, String username, String password,
                      String email,Boolean isCustomer) {
}
