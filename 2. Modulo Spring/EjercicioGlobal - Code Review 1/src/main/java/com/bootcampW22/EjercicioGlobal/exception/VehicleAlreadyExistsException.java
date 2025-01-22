package com.bootcampW22.EjercicioGlobal.exception;

public class VehicleAlreadyExistsException extends RuntimeException{
    public VehicleAlreadyExistsException(String message) {
        super(message);
    }
}
