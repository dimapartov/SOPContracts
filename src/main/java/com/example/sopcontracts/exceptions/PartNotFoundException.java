package com.example.sopcontracts.exceptions;

import java.util.UUID;


public class PartNotFoundException extends ResourceNotFoundException {

    public PartNotFoundException(UUID id) {
        super("Part", id.toString());
    }

}