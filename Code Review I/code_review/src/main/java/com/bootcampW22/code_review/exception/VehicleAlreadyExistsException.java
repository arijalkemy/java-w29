package com.bootcampW22.code_review.exception;

public class VehicleAlreadyExistsException extends RuntimeException {
    public VehicleAlreadyExistsException(Long id){
        super(String.format("El vehículo con id %d ya existe en la concesionaria.", id));
    }
}
