package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Payment;
import com.medicalshop.medical_shop_project.model.PaymentDTO;
import com.medicalshop.medical_shop_project.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<PaymentDTO> getPaymentById(Long p_id) {
        return paymentRepository.findById((p_id)).map(this::convertToDTO);
    }

    @Override
    public PaymentDTO savePayment(PaymentDTO paymentDTO) {
        Payment payment = convertToEntity(paymentDTO);
        Payment savedPayment = paymentRepository.save(payment);
        return convertToDTO(savedPayment);
    }


    @Override
    public PaymentDTO updatePayment(Long p_id, PaymentDTO paymentDTO) {
        Payment payment = paymentRepository.findById(p_id).orElseThrow();
        payment.setPaymentMethod(paymentDTO.paymentMethod());
        payment.setAmount(paymentDTO.amount());
        Payment updatedPayment = paymentRepository.save(payment);
        return convertToDTO(updatedPayment);
    }

    @Override
    public void deletePayment(Long p_id) {
        paymentRepository.deleteById(p_id);
    }

    //Conversion methods between DTO and Entity
    private PaymentDTO convertToDTO(Payment payment) {
        return new PaymentDTO(payment.getP_id(), payment.getAmount(), payment.getPaymentMethod(), payment.getP_date(), payment.getOrder1());
    }

    private Payment convertToEntity(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setAmount(paymentDTO.amount());
        payment.setPaymentMethod(paymentDTO.paymentMethod());
        return payment;
    }
}
