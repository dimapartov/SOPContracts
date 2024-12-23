package com.example.sopcontracts.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record OrderRequest(
        @NotNull(message = "Employee Id is mandatory")
        UUID employeeId,

        @NotBlank(message = "Customer name is mandatory")
        String customerName,

        @Email(message = "Email should be valid")
        @NotBlank(message = "Customer email is mandatory")
        String customerEmail
) {

}