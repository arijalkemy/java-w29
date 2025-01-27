package com.bootcampW22.EjercicioGlobal.exception;

public class IdAlreadyInUseException extends RuntimeException{
    public IdAlreadyInUseException(Long vehicleId) {
        super(String.format("The ID %s is already registered", vehicleId));
    }
}
