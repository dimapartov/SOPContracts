package com.example.sopcontracts.dtos;

import java.math.BigDecimal;
import java.util.UUID;


public record PartResponse(
        UUID id,
        String name,
        int quantityOnStorage,
        BigDecimal price
) {

}