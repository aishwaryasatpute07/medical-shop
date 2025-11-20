package com.medicalshop.medical_shop_project.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    // FK references medicine(m_id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id", referencedColumnName = "m_id", nullable = false)
    private Medicine medicine;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // Price captured at the time of adding to cart
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    // Generated always as (quantity * price) STORED — do not set in code
    // @Column(name = "total_price", nullable = false, precision = 10, scale = 2, insertable = false, updatable = false)
    @Column(name = "total_price", insertable = false, updatable = false)
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

    public Cart() {
    }

    public Cart(Medicine medicine, Long cartId, Long customerId, Integer quantity, BigDecimal price, BigDecimal totalPrice, Timestamp createdAt, Timestamp updatedAt) {
        this.medicine = medicine;
        this.cartId = cartId;
        this.customerId = customerId;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // getters and setters
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        recalcTotal();
    }


    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        recalcTotal();
    }

    private void recalcTotal() {
        if (this.price != null && this.quantity != null) {
            this.totalPrice = this.price.multiply(BigDecimal.valueOf(this.quantity));
        } else {
            this.totalPrice = BigDecimal.ZERO;
        }
    }


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customerId=" + customerId +
                ", medicine=" + medicine +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}