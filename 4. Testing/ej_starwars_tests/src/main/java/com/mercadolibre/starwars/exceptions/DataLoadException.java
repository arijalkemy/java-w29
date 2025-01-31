package com.mercadolibre.starwars.exceptions;

public class DataLoadException extends RuntimeException {
  public DataLoadException(String message) {
    super(message);
  }
}
