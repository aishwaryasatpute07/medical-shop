package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.PaymentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PaymentService {
    List<PaymentDTO> getAllPayments();

    Optional<PaymentDTO> getPaymentById(Long p_id);

    PaymentDTO savePayment(PaymentDTO paymentDTO);

    PaymentDTO updatePayment(Long p_id, PaymentDTO paymentDTO);

    void deletePayment(Long p_id);
}
