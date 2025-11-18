package com.medicalshop.medical_shop_project.repository;

import com.medicalshop.medical_shop_project.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
