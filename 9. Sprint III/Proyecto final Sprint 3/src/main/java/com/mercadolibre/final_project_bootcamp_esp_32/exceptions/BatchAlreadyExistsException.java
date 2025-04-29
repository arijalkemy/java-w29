package com.mercadolibre.final_project_bootcamp_esp_32.exceptions;

import org.springframework.http.HttpStatus;

public class BatchAlreadyExistsException extends ApiException {
    private static final String CONFLICT = "conflict";

    public BatchAlreadyExistsException(String description) {
        super(CONFLICT, description, HttpStatus.CONFLICT.value());
    }
}
