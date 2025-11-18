package com.medicalshop.medical_shop_project.model;

public record CustomerDTO(Long c_id,String c_name, String c_email, String c_password, String c_address, Boolean isUser) {
}
