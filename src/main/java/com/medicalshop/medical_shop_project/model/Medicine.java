package com.medicalshop.medical_shop_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long m_id;
    private String m_name;
    private String m_manufacturer;
    private Float m_price;
    private Date expiry_date;
    private Long stock_quantity;

    public Medicine(){}

    public Medicine(Long m_id, String m_name, String m_manufacturer, Float m_price, Date expiry_date, Long stock_quantity)
    {
        this.m_id = m_id;
        this.m_name = m_name;
        this.m_manufacturer = m_manufacturer;
        this.m_price = m_price;
        this.expiry_date = expiry_date;
        this.stock_quantity = stock_quantity;
    }

    public Long getM_id(){return m_id;}
    public void setM_id(Long m_id){this.m_id = m_id;}

    public String getM_name(){return m_name;}
    public void setM_name(String m_name){this.m_name = m_name;}

    public String getM_manufacturer(){return m_manufacturer;}
    public void setM_manufacturer(String m_manufacturer){this.m_manufacturer = m_manufacturer;}

    public Float getM_price(){return m_price;}
    public void setM_price(Float m_price){this.m_price = m_price;}

    public Date getExpiry_date(){return expiry_date;}
    public void setExpiry_date(Date expiry_date){this.expiry_date = expiry_date;}

    public Long getStock_quantity(){return stock_quantity;}
    public void setStock_quantity(Long stock_quantity){this.stock_quantity = stock_quantity;}
}
