package com.mercadolibre.javawave29.concesionaria_de_autos.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class AddVehicleException extends RuntimeException {
    private final List<String> errors;
    public AddVehicleException(List<String> errors) {
        this.errors = errors;
    }
}
