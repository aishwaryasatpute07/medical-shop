package com.medicalshop.medical_shop_project.model;

import java.util.Date;

public record MedicineDTO(Long m_id, String m_name, String m_manufacturer, Float m_price, Date expiry_date, Long stock_quantity, String cat) {
}
