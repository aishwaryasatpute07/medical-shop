package com.medicalshop.medical_shop_project.repository;

import com.medicalshop.medical_shop_project.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
