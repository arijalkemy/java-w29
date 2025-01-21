package org.example.ejerciciocovid.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(NoSouchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(NoSouchElementException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
