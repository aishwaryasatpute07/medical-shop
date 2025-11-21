package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Payment;
import com.medicalshop.medical_shop_project.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment makePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentByOrderId(Long orderId) {
        return paymentRepository.findAll()
                .stream()
                .filter(p -> p.getOrder().getOrderId().equals(orderId))
                .findFirst()
                .orElse(null);
    }
}