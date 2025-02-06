package com.meli.obtenerdiploma.exceptions;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

  @ExceptionHandler
  public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
    return ResponseEntity.badRequest().body(exception.getBindingResult().getFieldErrors().stream()
      .collect(Collectors.toMap(
        error -> error.getField(), 
        error -> error.getDefaultMessage()
      )));
  }

  @ExceptionHandler
  public ResponseEntity<?> httpMessageNotReadableExceptionHandler(
      HttpMessageNotReadableException exception
  ){
    Throwable rootCause = exception.getRootCause();
    String message = (rootCause != null) ? rootCause.getMessage() : "Unexpected error";
    return ResponseEntity.badRequest().body(message);
  }
}
