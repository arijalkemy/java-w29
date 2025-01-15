package com.example.ejercicio_links.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NoLoEncontramosLoco.class)
    public ResponseEntity<?> noLoEncontramos(NoLoEncontramosLoco e){
        return new ResponseEntity<>(, HttpStatus.NOT_FOUND);
    }
}
