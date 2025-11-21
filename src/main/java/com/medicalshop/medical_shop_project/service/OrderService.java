package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
}
