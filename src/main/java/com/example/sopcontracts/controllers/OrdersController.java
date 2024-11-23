/*
package com.example.sopcontracts.controllers;

import com.example.sopcontracts.dtos.OrderRequest;
import com.example.sopcontracts.dtos.OrderResponse;
import com.example.sopcontracts.enums.OrderStatusEnum;
import com.example.sopcontracts.exceptions.OrderNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
public class OrdersController implements OrdersApi {

    private List<OrderResponse> orders = new ArrayList<>();

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        UUID orderId = UUID.randomUUID();
        OrderResponse order = new OrderResponse(orderId, orderRequest.employeeId(), orderRequest.customerName(), orderRequest.customerEmail(), OrderStatusEnum.CREATED);
        orders.add(order);
        return order;
    }

    @Override
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        if (orders.isEmpty()) {
            throw new OrderNotFoundException(UUID.randomUUID());
        }
        return ResponseEntity.ok(orders);
    }

    @Override
    public ResponseEntity<OrderResponse> getOrderById(UUID id) {
        return orders.stream()
                .filter(order -> order.id().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public ResponseEntity<OrderResponse> updateOrderStatus(UUID id, String newStatus) {
        OrderResponse order = orders.stream()
                .filter(o -> o.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new OrderNotFoundException(id));

        order = new OrderResponse(order.id(), order.employeeId(), order.customerName(), order.customerEmail(), OrderStatusEnum.valueOf(newStatus));
        return ResponseEntity.ok(order);
    }

    @Override
    public ResponseEntity<Boolean> deleteOrder(UUID id) {
        boolean removed = orders.removeIf(order -> order.id().equals(id));
        if (!removed) {
            throw new OrderNotFoundException(id);
        }
        return ResponseEntity.ok(true);
    }

}*/