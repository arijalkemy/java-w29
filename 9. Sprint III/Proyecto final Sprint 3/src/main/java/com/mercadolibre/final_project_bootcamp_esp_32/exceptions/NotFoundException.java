package com.mercadolibre.final_project_bootcamp_esp_32.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {

    private static final String NOT_FOUND = "not_found";

    public NotFoundException(String description) {
        super(NOT_FOUND, description, HttpStatus.NOT_FOUND.value());
    }
}
