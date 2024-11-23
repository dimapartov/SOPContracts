package com.example.sopcontracts.controllers;

import com.example.sopcontracts.dtos.ErrorResponse;
import com.example.sopcontracts.dtos.OrderRequest;
import com.example.sopcontracts.dtos.OrderResponse;
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


@Tag(name = "Orders", description = "API для работы с заказами")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = OrderResponse.class))),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)))
})
public interface OrdersApi {

    @Operation(summary = "Создать новый заказ")
    @PostMapping(value = "/api/orders/create", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<OrderResponse>> createOrder(@Valid @RequestBody OrderRequest orderRequest);

    @Operation(summary = "Получить список всех заказов")
    @GetMapping("/api/orders/all")
    ResponseEntity<CollectionModel<EntityModel<OrderResponse>>> getAllOrders();

    @Operation(summary = "Получить заказ по ID")
    @GetMapping("/api/orders/{orderId}")
    ResponseEntity<EntityModel<OrderResponse>> getOrderById(@PathVariable UUID orderId);

    @Operation(summary = "Обновить статус заказа")
    @PutMapping("/api/orders/update/{orderId}")
    ResponseEntity<EntityModel<OrderResponse>> updateOrderStatus(@PathVariable UUID orderId, @RequestParam String newStatus);

    @Operation(summary = "Удалить заказ по ID")
    @DeleteMapping("/api/orders/delete/{orderId}")
    ResponseEntity<String> deleteOrder(@PathVariable UUID orderId);

}