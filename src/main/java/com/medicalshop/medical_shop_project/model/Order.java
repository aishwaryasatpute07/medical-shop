package com.medicalshop.medical_shop_project.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ord_id;
    private String prod_name;
    private Double price;
    private Date ord_date;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> paymentList;

    @ManyToOne
    @JoinColumn(name = "c_id", nullable = false)
    private Customer customer;

    public Order(){}

    public Order(Long ord_id, String prod_name,Double price, Date ord_date, Customer customer){
        this.ord_id = ord_id;
        this.prod_name = prod_name;
        this.price = price;
        this.ord_date = ord_date;
        this.customer = customer;
    }

    public Long getOrd_id() {
        return ord_id;
    }

    public void setOrd_date(Date ord_date) {
        this.ord_date = ord_date;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getOrd_date() {
        return ord_date;
    }

    public void setOrd_id(Long ord_id) {
        this.ord_id = ord_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
