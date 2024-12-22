package com.example.sopcontracts.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record EmployeeRequest(
        @NotBlank(message = "First name is mandatory")
        String firstName,

        @NotBlank(message = "Last name is mandatory")
        String lastName,

        @Email(message = "Email should be valid")
        @NotBlank(message = "Email is mandatory")
        String email,

        @NotBlank(message = "Phone number is mandatory")
        String phoneNumber
) {

}