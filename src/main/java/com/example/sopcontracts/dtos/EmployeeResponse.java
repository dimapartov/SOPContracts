package com.example.sopcontracts.dtos;

import java.util.UUID;


public record EmployeeResponse(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {
}