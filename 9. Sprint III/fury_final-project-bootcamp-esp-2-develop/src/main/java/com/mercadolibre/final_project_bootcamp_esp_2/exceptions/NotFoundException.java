package com.mercadolibre.final_project_bootcamp_esp_2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
