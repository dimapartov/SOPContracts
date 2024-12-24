package com.example.sopcontracts.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record PartRequest(
        @NotBlank(message = "Part name is mandatory")
        String name,
        @NotBlank(message = "Quantity on storage is mandatory")
        @NotNull(message = "Quantity is mandatory")
        int quantityOnStorage,
        @NotNull(message = "Quantity is mandatory")
        @NotBlank(message = "Price is mandatory")
        BigDecimal price
) {

}