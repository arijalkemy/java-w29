package com.example.ejemploSpring.exception;

import com.example.ejemploSpring.dto.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<?> notFoundException(ClientNotFoundException exception){
        ErrorDto errorDto = new ErrorDto("Excepción: "+exception.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> notFoundException(HttpMessageNotReadableException exception){
        ErrorDto errorDto = new ErrorDto("Excepción: "+exception.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> arithmeticException(ArithmeticException exception){
        ErrorDto errorDto = new ErrorDto("Excepción: "+exception.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
