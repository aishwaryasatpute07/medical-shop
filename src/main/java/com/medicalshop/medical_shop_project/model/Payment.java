package com.medicalshop.medical_shop_project.model;

import com.medicalshop.medical_shop_project.model.enums.PaymentMode;
import com.medicalshop.medical_shop_project.model.enums.TransactionStatus;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    // Child side of Order -> Payment
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    @JsonBackReference
    private Order order;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    private LocalDateTime paymentDate = LocalDateTime.now();

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus = TransactionStatus.PENDING;

    // Getters and Setters
    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public PaymentMode getPaymentMode() { return paymentMode; }
    public void setPaymentMode(PaymentMode paymentMode) { this.paymentMode = paymentMode; }

    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public TransactionStatus getTransactionStatus() { return transactionStatus; }
    public void setTransactionStatus(TransactionStatus transactionStatus) { this.transactionStatus = transactionStatus; }
}