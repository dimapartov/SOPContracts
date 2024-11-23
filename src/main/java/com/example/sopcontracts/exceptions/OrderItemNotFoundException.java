package com.example.sopcontracts.exceptions;

import java.util.UUID;


public class OrderItemNotFoundException extends ResourceNotFoundException {

    public OrderItemNotFoundException(UUID id) {
        super("OrderItem", id.toString());
    }

}