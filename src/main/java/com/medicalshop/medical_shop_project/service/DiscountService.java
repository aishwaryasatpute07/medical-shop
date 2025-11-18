package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.DiscountDTO;

import java.util.List;
import java.util.Optional;

public interface DiscountService {
    List<DiscountDTO> getAllDiscounts();

    Optional<DiscountDTO> getDiscountById(Long disc_id);

    DiscountDTO saveDiscount(DiscountDTO discountDTO);

    DiscountDTO updateDiscount(Long disc_id, DiscountDTO discountDTO);

    void deleteDiscount(Long disc_id);
}
