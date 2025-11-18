package com.medicalshop.medical_shop_project.controller;

import com.medicalshop.medical_shop_project.model.OrderDTO;
import com.medicalshop.medical_shop_project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getAllOrders")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long ord_id) {
        Optional<OrderDTO> order = orderService.getOrderById(ord_id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.saveOrder(orderDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long ord_id, @RequestBody OrderDTO orderDTO) {
        try {
            OrderDTO updateOrder = orderService.updateOrder(ord_id, orderDTO);
            return ResponseEntity.ok(updateOrder);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long ord_id) {
        orderService.deleteOrder(ord_id);
        return ResponseEntity.noContent().build();
    }
}
