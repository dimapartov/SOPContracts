package com.example.sopcontracts.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record OrderItemRequest(
        @NotNull(message = "Order Id is mandatory")
        UUID orderId,

        @NotNull(message = "Part Id is mandatory")
        UUID partId,

        @NotNull(message = "Quantity is mandatory")
        int quantity
) {

}