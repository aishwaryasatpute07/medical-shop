package com.medicalshop.medical_shop_project.repository;

import com.medicalshop.medical_shop_project.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
