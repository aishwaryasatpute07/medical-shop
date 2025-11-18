package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Discount;
import com.medicalshop.medical_shop_project.model.DiscountDTO;
import com.medicalshop.medical_shop_project.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<DiscountDTO> getAllDiscounts() {
        return discountRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<DiscountDTO> getDiscountById(Long disc_id) {
        return discountRepository.findById((disc_id)).map(this::convertToDTO);
    }

    @Override
    public DiscountDTO saveDiscount(DiscountDTO discountDTO) {
        Discount discount = convertToEntity(discountDTO);
        Discount savedDiscount = discountRepository.save(discount);
        return convertToDTO(savedDiscount);
    }


    @Override
    public DiscountDTO updateDiscount(Long disc_id, DiscountDTO discountDTO) {
        Discount discount = discountRepository.findById(disc_id).orElseThrow();
        discount.setDisc_offers(discountDTO.disc_offers());
        discount.setEnd_date(discountDTO.end_date());
        Discount updatedDiscount = discountRepository.save(discount);
        return convertToDTO(updatedDiscount);
    }

    @Override
    public void deleteDiscount(Long disc_id) {
        discountRepository.deleteById(disc_id);
    }

    //Conversion methods between DTO and Entity
    private DiscountDTO convertToDTO(Discount discount) {
        return new DiscountDTO(discount.getDisc_id(), discount.getDisc_offers(), discount.getDisc_value(), discount.getStart_date(), discount.getEnd_date(),discount.getPayment1());
    }

    private Discount convertToEntity(DiscountDTO discountDTO) {
        Discount discount = new Discount();
        discount.setDisc_value(discountDTO.disc_value());
        discount.setEnd_date(discountDTO.end_date());
        return discount;
    }
}
