package com.mercadolibre.final_project_bootcamp_esp_2.exceptions;

public class BadRequestException extends RuntimeException {
  public BadRequestException(String message){
    super(message);
  }
}
