package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.OrderItem;
import com.medicalshop.medical_shop_project.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getItemsByOrderId(Long orderId) {
        return orderItemRepository.findAll()
                .stream()
                .filter(item -> item.getOrder().getOrderId().equals(orderId))
                .toList();
    }
}