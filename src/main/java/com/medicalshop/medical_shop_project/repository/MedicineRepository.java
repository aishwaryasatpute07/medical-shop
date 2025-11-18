package com.medicalshop.medical_shop_project.repository;

import com.medicalshop.medical_shop_project.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
