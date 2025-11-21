package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem addOrderItem(OrderItem orderItem);
    List<OrderItem> getItemsByOrderId(Long orderId);
}
