package com.medicalshop.medical_shop_project.repository;

import com.medicalshop.medical_shop_project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
