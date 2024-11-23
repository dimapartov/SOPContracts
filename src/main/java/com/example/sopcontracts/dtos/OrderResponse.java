package com.example.sopcontracts.dtos;

import com.example.sopcontracts.enums.OrderStatusEnum;

import java.util.UUID;


public record OrderResponse(
        UUID id,
        UUID employeeId,
        String customerName,
        String customerEmail,
        OrderStatusEnum orderStatus
) {

}