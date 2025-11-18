package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.MedicineDTO;
import com.medicalshop.medical_shop_project.model.SupplierDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    List<MedicineDTO> getAllMedicines();

    Optional<MedicineDTO> getMedicineById(Long m_id);

    MedicineDTO saveMedicine(MedicineDTO medicineDTO);

    MedicineDTO updateMedicine(Long m_id, MedicineDTO medicineDTO);

    void deleteMedicine(Long m_id);
}