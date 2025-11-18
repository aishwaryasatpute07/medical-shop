package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Medicine;
import com.medicalshop.medical_shop_project.model.MedicineDTO;
import com.medicalshop.medical_shop_project.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<MedicineDTO> getAllMedicines() {
        return medicineRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<MedicineDTO> getMedicineById(Long m_id) {
        return medicineRepository.findById((m_id)).map(this::convertToDTO);
    }

    @Override
    public MedicineDTO saveMedicine(MedicineDTO medicineDTO) {
        Medicine medicine = convertToEntity(medicineDTO);
        Medicine savedMedicine = medicineRepository.save(medicine);
        return convertToDTO(savedMedicine);
    }


    @Override
    public MedicineDTO updateMedicine(Long m_id, MedicineDTO medicineDTO) {
        Medicine medicine = medicineRepository.findById(m_id).orElseThrow();
        medicine.setM_name(medicineDTO.m_name());
        medicine.setStock_quantity(medicineDTO.stock_quantity());
        Medicine updatedMedicine = medicineRepository.save(medicine);
        return convertToDTO(updatedMedicine);
    }

    @Override
    public void deleteMedicine(Long m_id) {
        medicineRepository.deleteById(m_id);
    }

    //Conversion methods between DTO and Entity
    private MedicineDTO convertToDTO(Medicine medicine) {
        return new MedicineDTO(medicine.getM_id(), medicine.getM_name(), medicine.getM_manufacturer(), medicine.getM_price(), medicine.getExpiry_date(), medicine.getStock_quantity());
    }

    private Medicine convertToEntity(MedicineDTO medicineDTO) {
        Medicine medicine = new Medicine();
        medicine.setM_name(medicineDTO.m_name());
        medicine.setStock_quantity(medicineDTO.stock_quantity());
        return medicine;
    }
}
