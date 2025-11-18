package com.medicalshop.medical_shop_project.model;

import java.util.Date;

public record PaymentDTO(Long p_id, Double amount, String paymentMethod, Date p_date, Order order1) {
}
