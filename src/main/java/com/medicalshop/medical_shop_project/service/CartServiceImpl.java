package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.AddToCartRequest;
import com.medicalshop.medical_shop_project.model.Cart;
import com.medicalshop.medical_shop_project.model.CartItemDTO;
import com.medicalshop.medical_shop_project.model.Medicine;
import com.medicalshop.medical_shop_project.repository.CartRepository;
import com.medicalshop.medical_shop_project.repository.MedicineRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final MedicineRepository medicineRepository;

    public CartServiceImpl(CartRepository cartRepository, MedicineRepository medicineRepository) {
        this.cartRepository = cartRepository;
        this.medicineRepository = medicineRepository;
    }

    @Override
    public CartItemDTO addToCart(AddToCartRequest request) {
        Medicine medicine = medicineRepository.findById(request.getMedicineId())
                .orElseThrow(() -> new IllegalArgumentException("Medicine not found: " + request.getMedicineId()));

        if (request.getQuantity() == null || request.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        // Upsert: if same medicine already exists for customer, update quantity instead of creating duplicate row
        Optional<Cart> existing = cartRepository.findByCustomerAndMedicine(request.getCustomerId(), request.getMedicineId());
        Cart cart;
        if (existing.isPresent()) {
            cart = existing.get();
            cart.setQuantity(cart.getQuantity() + request.getQuantity());
            // price remains the original captured price; alternatively, recapture current price policy-wise
        } else {
            cart = new Cart();
            cart.setCustomerId(request.getCustomerId());
            cart.setMedicine(medicine);
            cart.setQuantity(request.getQuantity());
            // Capture price at add time
            BigDecimal unitPrice = new BigDecimal(String.valueOf(medicine.getM_price()));
            cart.setPrice(unitPrice);
        }

        Cart saved = cartRepository.save(cart);
        return toDTO(saved);
    }

    @Override
    public List<CartItemDTO> getCartByCustomer(Long customerId) {
        return cartRepository.findByCustomerId(customerId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public CartItemDTO updateQuantity(Long cartId, Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Cart item not found: " + cartId));

        cart.setQuantity(quantity);
        Cart saved = cartRepository.save(cart);
        return toDTO(saved);
    }

    @Override
    public void removeItem(Long cartId) {
        if (!cartRepository.existsById(cartId)) {
            throw new IllegalArgumentException("Cart item not found: " + cartId);
        }
        cartRepository.deleteById(cartId);
    }

    @Override
    public void clearCart(Long customerId) {
        List<Cart> items = cartRepository.findByCustomerId(customerId);
        cartRepository.deleteAllInBatch(items);
    }

    private CartItemDTO toDTO(Cart cart) {
        CartItemDTO dto = new CartItemDTO();
        dto.setCartId(cart.getCartId());
        dto.setCustomerId(cart.getCustomerId());
        dto.setMedicineId(cart.getMedicine().getM_id());
        dto.setMedicineName(cart.getMedicine().getM_name());
        dto.setQuantity(cart.getQuantity());
        dto.setPrice(cart.getPrice());
        dto.setTotalPrice(cart.getTotalPrice());
        dto.setCreatedAt(cart.getCreatedAt());
        dto.setUpdatedAt(cart.getUpdatedAt());
        return dto;
    }
}