package com.medicalshop.medical_shop_project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long u_id;
    private String u_firstname;
    private String u_lastname;
    private Boolean isCustomer = false;
    private String username;
    private String password;
    private String email;

    public User() {
    }

    public User(String email, String password, String username, String u_lastname, String u_firstname, Long u_id, Boolean isCustomer) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.u_lastname = u_lastname;
        this.u_firstname = u_firstname;
        this.u_id = u_id;
        this.isCustomer = isCustomer;
    }

    //Getters and Setters
    public Long getId() {
        return u_id;
    }

    public void setId(Long u_id) {
        this.u_id = u_id;
    }

    public String getFirstname() {
        return u_firstname;
    }

    public void setFirstname(String u_firstname) {
        this.u_firstname = u_firstname;
    }

    public String getLastname() {
        return u_lastname;
    }

    public void setLastname(String u_lastname) {
        this.u_lastname = u_lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsCustomer(){return isCustomer;}

    public void setIsCustomer(Boolean isCustomer){this.isCustomer = isCustomer;}

}
