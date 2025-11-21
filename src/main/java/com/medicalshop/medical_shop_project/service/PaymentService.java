package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Payment;

public interface PaymentService {
    Payment makePayment(Payment payment);
    Payment getPaymentByOrderId(Long orderId);
}
