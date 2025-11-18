package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.SupplierDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierDTO> getAllSuppliers();

    Optional<SupplierDTO> getSupplierById(Long s_id);

    SupplierDTO saveSupplier(SupplierDTO supplierDTO);

    SupplierDTO updateSupplier(Long s_id, SupplierDTO supplierDTO);

    void deleteSupplier(Long s_id);
}
