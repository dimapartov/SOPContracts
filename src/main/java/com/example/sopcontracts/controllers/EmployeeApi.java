package com.example.sopcontracts.controllers;

import com.example.sopcontracts.dtos.EmployeeRequest;
import com.example.sopcontracts.dtos.EmployeeResponse;
import com.example.sopcontracts.dtos.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.UUID;

@Tag(name = "Employees", description = "API for managing employees")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Request processed successfully", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = EmployeeResponse.class))),
        @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)))
})
public interface EmployeeApi {

    @Operation(summary = "Create a new employee")
    @PostMapping(value = "/api/employees/create", produces = "application/json")
    ResponseEntity<EntityModel<EmployeeResponse>> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest);

    @Operation(summary = "Get all employees")
    @GetMapping(value = "/api/employees/all", produces = "application/json")
    ResponseEntity<CollectionModel<EntityModel<EmployeeResponse>>> getAllEmployees();

    @Operation(summary = "Get employee by ID")
    @GetMapping(value = "/api/employees/{employeeId}", produces = "application/json")
    ResponseEntity<EntityModel<EmployeeResponse>> getEmployeeById(@PathVariable UUID employeeId);

    @Operation(summary = "Delete an employee by ID")
    @DeleteMapping(value = "/api/employees/delete/{employeeId}")
    ResponseEntity<String> deleteEmployeeById(@PathVariable UUID employeeId);
}