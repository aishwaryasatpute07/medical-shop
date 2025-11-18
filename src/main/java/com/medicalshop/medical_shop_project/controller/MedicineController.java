package com.medicalshop.medical_shop_project.controller;

import com.medicalshop.medical_shop_project.model.MedicineDTO;
import com.medicalshop.medical_shop_project.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/getAllMedicines")
    public List<MedicineDTO> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineDTO> getMedicineById(@PathVariable Long m_id) {
        Optional<MedicineDTO> medicine = medicineService.getMedicineById(m_id);
        return medicine.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MedicineDTO createMedicine(@RequestBody MedicineDTO medicineDTO) {
        return medicineService.saveMedicine(medicineDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicineDTO> updateMedicine(@PathVariable Long m_id, @RequestBody MedicineDTO medicineDTO) {
        try {
            MedicineDTO updateMedicine = medicineService.updateMedicine(m_id, medicineDTO);
            return ResponseEntity.ok(updateMedicine);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long m_id) {
        medicineService.deleteMedicine(m_id);
        return ResponseEntity.noContent().build();
    }
}
