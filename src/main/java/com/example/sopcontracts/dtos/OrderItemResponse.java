package com.example.sopcontracts.dtos;

import java.util.UUID;


public record OrderItemResponse(
        UUID id,
        OrderResponse order,
        PartResponse part,
        int quantity
) {

}