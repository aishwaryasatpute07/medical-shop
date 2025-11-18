package com.medicalshop.medical_shop_project.controller;

import com.medicalshop.medical_shop_project.model.SupplierDTO;
import com.medicalshop.medical_shop_project.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/getAllSuppliers")
    public List<SupplierDTO> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long s_id) {
        Optional<SupplierDTO> supplier = supplierService.getSupplierById(s_id);
        return supplier.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SupplierDTO createSupplier(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.saveSupplier(supplierDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long s_id, @RequestBody SupplierDTO supplierDTO) {
        try {
            SupplierDTO updateSupplier = supplierService.updateSupplier(s_id, supplierDTO);
            return ResponseEntity.ok(updateSupplier);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long s_id) {
        supplierService.deleteSupplier(s_id);
        return ResponseEntity.noContent().build();
    }
}
