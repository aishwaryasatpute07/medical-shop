package com.medicalshop.medical_shop_project.controller;

import com.medicalshop.medical_shop_project.model.PaymentDTO;
import com.medicalshop.medical_shop_project.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getAllPayments")
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long p_id) {
        Optional<PaymentDTO> payment = paymentService.getPaymentById(p_id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PaymentDTO createPayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.savePayment(paymentDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable Long p_id, @RequestBody PaymentDTO paymentDTO) {
        try {
            PaymentDTO updatePayment = paymentService.updatePayment(p_id, paymentDTO);
            return ResponseEntity.ok(updatePayment);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long p_id) {
        paymentService.deletePayment(p_id);
        return ResponseEntity.noContent().build();
    }
}
