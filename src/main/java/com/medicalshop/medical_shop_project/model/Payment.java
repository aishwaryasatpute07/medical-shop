package com.medicalshop.medical_shop_project.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long p_id;
    private Double amount;
    private String paymentMethod;
    private Date p_date;

    @ManyToOne
    @JoinColumn(name = "ordid", nullable = false)
    private Order order;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Discount> discountList;

    public Payment(){}

    public Payment(Long p_id, Double amount, String paymentMethod, Date p_date, Order order){
        this.p_id = p_id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.p_date = p_date;
        this.order = order;
    }

    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Order getOrder1() {
        return order;
    }

    public void setOrder1(Order order) {
        this.order = order;
    }
}
