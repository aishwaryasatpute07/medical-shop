package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Discount;
import com.medicalshop.medical_shop_project.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public Discount createDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public Discount updateDiscount(Long id, Discount discount) {
        Discount existing = discountRepository.findById(id).orElseThrow();
        existing.setDiscOffers(discount.getDiscOffers());
        existing.setDiscValue(discount.getDiscValue());
        existing.setStartDate(discount.getStartDate());
        existing.setEndDate(discount.getEndDate());
        return discountRepository.save(existing);
    }

    @Override
    public void deleteDiscount(Long id) {
        discountRepository.deleteById(id);
    }

    @Override
    public Discount getDiscountById(Long id) {
        return discountRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }
}