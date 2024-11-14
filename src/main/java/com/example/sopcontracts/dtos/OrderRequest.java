package com.example.sopcontracts.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record OrderRequest(
        @NotNull(message = "ID сотрудника обязателен")
        UUID employeeId,

        @NotBlank(message = "Имя клиента обязательно")
        String customerName,

        @NotBlank(message = "Email клиента обязателен")
        String customerEmail
) {

}