package com.meli.ej_blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ExceptionDTO> handleResourceAlreadyExistsException(
            ResourceAlreadyExistsException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleResourceNotFoundException(
            NotFoundException e
    ) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
