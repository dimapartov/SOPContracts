package com.example.sopcontracts.dtos;

import java.math.BigDecimal;


public record PartRequest(
        String name,
        int quantityOnStorage,
        BigDecimal price
) {

}