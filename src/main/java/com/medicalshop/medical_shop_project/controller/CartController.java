package com.medicalshop.medical_shop_project.controller;

import com.medicalshop.medical_shop_project.model.AddToCartRequest;
import com.medicalshop.medical_shop_project.model.CartItemDTO;
import com.medicalshop.medical_shop_project.model.UpdateCartQuantityRequest;
import com.medicalshop.medical_shop_project.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Add to cart (upsert by customerId + medicineId)
    @PostMapping
    public ResponseEntity<CartItemDTO> addToCart(@RequestBody AddToCartRequest request) {
        CartItemDTO dto = cartService.addToCart(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    // Get all items by customer
    @GetMapping("/{customerId}")
    public ResponseEntity<List<CartItemDTO>> getCart(@PathVariable Long customerId) {
        return ResponseEntity.ok(cartService.getCartByCustomer(customerId));
    }

    // Update quantity
    @PutMapping("/{cartId}/quantity")
    public ResponseEntity<CartItemDTO> updateQuantity(@PathVariable Long cartId,
                                                      @RequestBody UpdateCartQuantityRequest request) {
        CartItemDTO dto = cartService.updateQuantity(cartId, request.getQuantity());
        return ResponseEntity.ok(dto);
    }

    // Remove one item
    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> removeItem(@PathVariable Long cartId) {
        cartService.removeItem(cartId);
        return ResponseEntity.noContent().build();
    }

    // Clear cart for a customer
    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<Void> clearCart(@PathVariable Long customerId) {
        cartService.clearCart(customerId);
        return ResponseEntity.noContent().build();
    }
}