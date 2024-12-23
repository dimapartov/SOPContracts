package com.example.sopcontracts.controllers;

import com.example.sopcontracts.dtos.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Tag(name = "Order items", description = "API for Order items")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Request processed successfully", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = OrderItemResponse.class))),
        @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)))
})
public interface OrderItemApi {

    @Operation(summary = "Create new order item")
    @PostMapping(value = "/api/order-items/create", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<OrderItemResponse>> createOrderItem(@Valid @RequestBody OrderItemRequest orderItemRequest);

    @Operation(summary = "Get all order items by order id")
    @GetMapping("/api/order-items/order/{orderId}")
    ResponseEntity<CollectionModel<EntityModel<OrderItemResponse>>> getAllOrderItemsByOrderId(@PathVariable UUID orderId);

    @Operation(summary = "Get order item by Id")
    @GetMapping("/api/order-items/{orderItemId}")
    ResponseEntity<EntityModel<OrderItemResponse>> getOrderItemById(@PathVariable UUID orderItemId);

    @Operation(summary = "Delete order item by Id")
    @DeleteMapping("/api/order-items/delete/{orderItemId}")
    ResponseEntity<String> deleteOrderItemById(@PathVariable UUID orderItemId);

}