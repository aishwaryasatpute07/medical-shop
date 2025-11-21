package com.medicalshop.medical_shop_project.model;

import java.util.Date;

public record DiscountDTO(Long disc_id, String disc_offers, Double disc_value, Date start_date, Date end_date, Payment payment) {
}
