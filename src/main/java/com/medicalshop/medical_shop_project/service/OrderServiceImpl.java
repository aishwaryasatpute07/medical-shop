package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Order;
import com.medicalshop.medical_shop_project.model.OrderDTO;
import com.medicalshop.medical_shop_project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<OrderDTO> getOrderById(Long ord_id) {
        return orderRepository.findById((ord_id)).map(this::convertToDTO);
    }

    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        Order order = convertToEntity(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }


    @Override
    public OrderDTO updateOrder(Long ord_id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(ord_id).orElseThrow();
        order.setProd_name(orderDTO.prod_name());
        order.setPrice(orderDTO.price());
        Order updatedOrder = orderRepository.save(order);
        return convertToDTO(updatedOrder);
    }

    @Override
    public void deleteOrder(Long ord_id) {
        orderRepository.deleteById(ord_id);
    }

    //Conversion methods between DTO and Entity
    private OrderDTO convertToDTO(Order order) {
        return new OrderDTO(order.getOrd_id(), order.getProd_name(), order.getPrice(), order.getOrd_date(), order.getCustomer());
    }

    private Order convertToEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setProd_name(orderDTO.prod_name());
        order.setPrice(orderDTO.price());
        return order;
    }
}
