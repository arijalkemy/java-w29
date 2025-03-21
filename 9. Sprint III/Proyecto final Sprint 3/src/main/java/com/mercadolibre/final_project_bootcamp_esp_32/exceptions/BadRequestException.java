package com.mercadolibre.final_project_bootcamp_esp_32.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException{
    private static final String BAD_REQUEST = "bad_request";

    public BadRequestException(String description) {
        super(BAD_REQUEST, description, HttpStatus.BAD_REQUEST.value());
    }
}
