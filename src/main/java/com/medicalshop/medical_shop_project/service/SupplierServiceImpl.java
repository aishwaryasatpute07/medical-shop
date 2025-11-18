package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Supplier;
import com.medicalshop.medical_shop_project.model.SupplierDTO;
import com.medicalshop.medical_shop_project.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<SupplierDTO> getSupplierById(Long s_id) {
        return supplierRepository.findById((s_id)).map(this::convertToDTO);
    }

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = convertToEntity(supplierDTO);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return convertToDTO(savedSupplier);
    }


    @Override
    public SupplierDTO updateSupplier(Long s_id, SupplierDTO supplierDTO) {
        Supplier supplier = supplierRepository.findById(s_id).orElseThrow();
        supplier.setName(supplierDTO.s_name());
        supplier.setEmail(supplierDTO.email());
        Supplier updatedSupplier = supplierRepository.save(supplier);
        return convertToDTO(updatedSupplier);
    }

    @Override
    public void deleteSupplier(Long s_id) {
        supplierRepository.deleteById(s_id);
    }

    //Conversion methods between DTO and Entity
    private SupplierDTO convertToDTO(Supplier supplier) {
        return new SupplierDTO(supplier.getId(), supplier.getName(), supplier.getAddress(), supplier.getPassword(), supplier.getEmail());
    }

    private Supplier convertToEntity(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierDTO.s_name());
        supplier.setEmail(supplierDTO.email());
        return supplier;
    }
}
