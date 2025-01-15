package com.mercadolibre.javawave29.concesionaria_de_autos.exceptions;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String message) {
        super(message);
    }
}
