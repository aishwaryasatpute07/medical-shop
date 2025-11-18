package com.medicalshop.medical_shop_project.controller;

import com.medicalshop.medical_shop_project.model.DiscountDTO;
import com.medicalshop.medical_shop_project.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/getAllDiscounts")
    public List<DiscountDTO> getAllDiscounts() {
        return discountService.getAllDiscounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountDTO> getDiscountById(@PathVariable Long disc_id) {
        Optional<DiscountDTO> discount = discountService.getDiscountById(disc_id);
        return discount.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DiscountDTO createDiscount(@RequestBody DiscountDTO discountDTO) {
        return discountService.saveDiscount(discountDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountDTO> updateDiscount(@PathVariable Long disc_id, @RequestBody DiscountDTO discountDTO) {
        try {
            DiscountDTO updateDiscount = discountService.updateDiscount(disc_id, discountDTO);
            return ResponseEntity.ok(updateDiscount);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscount(@PathVariable Long disc_id) {
        discountService.deleteDiscount(disc_id);
        return ResponseEntity.noContent().build();
    }
}
