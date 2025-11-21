package com.medicalshop.medical_shop_project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discId;

    @Column(nullable = false)
    private String discOffers;

    @Column(nullable = false)
    private BigDecimal discValue;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "discount")
    private List<Medicine> medicines;

    // --- Getters and Setters ---
    public Long getDiscId() {
        return discId;
    }

    public void setDiscId(Long discId) {
        this.discId = discId;
    }

    public String getDiscOffers() {
        return discOffers;
    }

    public void setDiscOffers(String discOffers) {
        this.discOffers = discOffers;
    }

    public BigDecimal getDiscValue() {
        return discValue;
    }

    public void setDiscValue(BigDecimal discValue) {
        this.discValue = discValue;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}