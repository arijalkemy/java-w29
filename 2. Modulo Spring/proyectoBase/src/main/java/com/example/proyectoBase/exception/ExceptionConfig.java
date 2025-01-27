package com.example.proyectoBase.exception;

import com.example.proyectoBase.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(e.getMessage()));
    }

    @ExceptionHandler(VehicleIdAlreadyExistsException.class)
    public ResponseEntity<?> vehicleIdAlreadyExists(VehicleIdAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionDto(e.getMessage()));
    }
}
