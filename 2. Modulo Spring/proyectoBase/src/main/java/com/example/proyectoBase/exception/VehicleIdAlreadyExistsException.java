package com.example.proyectoBase.exception;

public class VehicleIdAlreadyExistsException extends RuntimeException {

    public VehicleIdAlreadyExistsException(Long id) {
        super(String.format("Ya existe un vehiculo con el ID %d", id));
    }
}
