package com.org.meli.ejercicioBlog.exception;

import com.org.meli.ejercicioBlog.dto.response.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(EntradaBlogNotFoundException.class)
    public ResponseEntity<ExceptionDto> notFound(EntradaBlogNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(e.getMessage()));
    }

    @ExceptionHandler(EntradaBlogAlreadyExistsException.class)
    public ResponseEntity<ExceptionDto> alreadyExists(EntradaBlogAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionDto(e.getMessage()));
    }
}
