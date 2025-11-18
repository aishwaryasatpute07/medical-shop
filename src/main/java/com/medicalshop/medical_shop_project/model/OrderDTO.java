package com.medicalshop.medical_shop_project.model;

import java.util.Date;

public record OrderDTO(Long ord_id, String prod_name, Double price, Date ord_date, Customer customer) {
}
