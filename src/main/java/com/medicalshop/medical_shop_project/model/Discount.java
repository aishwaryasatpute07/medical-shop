package com.medicalshop.medical_shop_project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long disc_id;
    private String disc_offers;
    private Double disc_value;
    private Date start_date;
    private Date end_date;

    @ManyToOne
    @JoinColumn(name = "p_id", nullable = false)
    private Payment payment;

    public Discount(){}

    public Discount(Long disc_id, String disc_offers, Double disc_value, Date start_date, Date end_date, Payment payment){
        this.disc_id = disc_id;
        this.disc_offers = disc_offers;
        this.disc_value = disc_value;
        this.start_date = start_date;
        this.end_date = end_date;
        this.payment = payment;
    }

    public Long getDisc_id() {
        return disc_id;
    }

    public void setDisc_id(Long disc_id) {
        this.disc_id = disc_id;
    }

    public String getDisc_offers() {
        return disc_offers;
    }

    public void setDisc_offers(String disc_offers) {
        this.disc_offers = disc_offers;
    }

    public Double getDisc_value() {
        return disc_value;
    }

    public void setDisc_value(Double disc_value) {
        this.disc_value = disc_value;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Payment getPayment1() {
        return payment;
    }

    public void setPayment1(Payment payment) {
        this.payment = payment;
    }
}
