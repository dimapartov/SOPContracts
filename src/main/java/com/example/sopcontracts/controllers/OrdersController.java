package com.example.sopcontracts.controllers;

import com.example.sopcontracts.dtos.OrderRequest;
import com.example.sopcontracts.dtos.OrderResponse;
import com.example.sopcontracts.dtos.OrderStatusEnum;
import com.example.sopcontracts.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class OrdersController implements OrdersApi {

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return null;
    }

    @Override
    public ResponseEntity<OrderResponse> getOrderById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<OrderResponse> updateOrderStatus(UUID id, String newStatus) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> deleteOrder(UUID id) {
        return null;
    }

}