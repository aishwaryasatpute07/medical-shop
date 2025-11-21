package com.medicalshop.medical_shop_project.repository;

import com.medicalshop.medical_shop_project.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
