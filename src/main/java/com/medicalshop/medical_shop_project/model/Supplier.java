package com.medicalshop.medical_shop_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long s_id;
    private String s_name;
    private String email;
    private String password;
    private String s_address;

    public Supplier() {
    }

    public Supplier(Long s_id, String s_name, String email, String password, String s_address)
    {
        this.s_id = s_id;
        this.s_name = s_name;
        this.email = email;
        this.password = password;
        this.s_address = s_address;
    }

    public Long getId(){return s_id;}
    public void setId(long s_id){this.s_id = s_id;}

    public String getName(){return s_name;}
    public void setName(String s_name){this.s_name = s_name;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public String getAddress(){return s_address;}
    public void setAddress(String s_address){this.s_address = s_address;}
}
