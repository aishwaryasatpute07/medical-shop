package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Discount;
import java.util.List;

public interface DiscountService {
    Discount createDiscount(Discount discount);
    Discount updateDiscount(Long id, Discount discount);
    void deleteDiscount(Long id);
    Discount getDiscountById(Long id);
    List<Discount> getAllDiscounts();
}