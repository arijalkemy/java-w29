package com.bootcampW22.EjercicioGlobal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class AddVehicleException extends RuntimeException {

    private final List<String> errors;

    public AddVehicleException(String message, List<String> errors) {
    super(message);
    this.errors = errors;
  }
}
