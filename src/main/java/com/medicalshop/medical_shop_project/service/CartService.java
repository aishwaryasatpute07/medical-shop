package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.AddToCartRequest;
import com.medicalshop.medical_shop_project.model.CartItemDTO;

import java.util.List;

public interface CartService {
    CartItemDTO addToCart(AddToCartRequest request);

    List<CartItemDTO> getCartByCustomer(Long customerId);

    CartItemDTO updateQuantity(Long cartId, Integer quantity);

    void removeItem(Long cartId);

    void clearCart(Long customerId);
}