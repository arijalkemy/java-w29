package com.bootcampW22.EjercicioGlobal.exception;

public class InvalidVehicleDataException extends RuntimeException{
    public InvalidVehicleDataException() {
        super("The vehicle contains invalid data");
    }
}
