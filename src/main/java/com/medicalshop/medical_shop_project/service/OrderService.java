package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.OrderDTO;
import com.medicalshop.medical_shop_project.model.SupplierDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<OrderDTO> getAllOrders();

    Optional<OrderDTO> getOrderById(Long ord_id);

    OrderDTO saveOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(Long ord_id, OrderDTO orderDTO);

    void deleteOrder(Long ord_id);
}
