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


@Tag(name = "Parts", description = "API for parts")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Request processed successfully", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = PartResponse.class))),
        @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)))
})
public interface PartApi {

    @Operation(summary = "Create new part")
    @PostMapping(value = "/api/parts/create", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<PartResponse>> createPart(@Valid @RequestBody PartRequest partRequest);

    @Operation(summary = "Update part quantity on storage")
    @GetMapping("/api/parts/update{partId}")
    ResponseEntity<EntityModel<PartResponse>> changeQuantityOnStorage(@PathVariable UUID partId, @RequestParam int newQuantityOnStorage);

    @Operation(summary = "Get part by Id")
    @GetMapping("/api/parts/{partId}")
    ResponseEntity<EntityModel<PartResponse>> getPartById(@PathVariable UUID partId);

    @Operation(summary = "Get all parts")
    @GetMapping("/api/parts/all")
    ResponseEntity<CollectionModel<EntityModel<PartResponse>>> getAllParts();

    @Operation(summary = "Delete part by Id")
    @DeleteMapping("/api/parts/delete/{partId}")
    ResponseEntity<String> deletePartById(@PathVariable UUID partId);

}