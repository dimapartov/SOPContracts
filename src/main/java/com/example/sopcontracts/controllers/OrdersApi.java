package com.example.sopcontracts.controllers;

import com.example.sopcontracts.dtos.OrderRequest;
import com.example.sopcontracts.dtos.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Orders", description = "API для работы с заказами")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface OrdersApi {

    @Operation(summary = "Создать новый заказ")
    @PostMapping(value = "/api/orders/create", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderResponse createOrder(@Valid @RequestBody OrderRequest orderRequest);

/*
    @Operation(summary = "Получить список всех заказов")
    @ApiResponse(responseCode = "200", description = "Получен список всех заказов")
    @GetMapping("/api/orders/all")
    ResponseEntity<List<OrderResponse>> getAllOrders();

    @Operation(summary = "Получить заказ по ID")
    @ApiResponse(responseCode = "200", description = "Получен заказ по ID")
    @GetMapping("/api/orders/{id}")
    ResponseEntity<OrderResponse> getOrderById(@PathVariable UUID id);

    @Operation(summary = "Обновить статус заказа")
    @ApiResponse(responseCode = "200", description = "Статус заказа обновлен")
    @PutMapping("/api/orders/update/{id}")
    ResponseEntity<OrderResponse> updateOrderStatus(@PathVariable UUID id, @RequestParam String newStatus);

    @Operation(summary = "Удалить заказ по ID")
    @ApiResponse(responseCode = "204", description = "Заказ успешно удален")
    @DeleteMapping("/api/orders/delete/{id}")
    ResponseEntity<Void> deleteOrder(@PathVariable UUID id);
*/

}