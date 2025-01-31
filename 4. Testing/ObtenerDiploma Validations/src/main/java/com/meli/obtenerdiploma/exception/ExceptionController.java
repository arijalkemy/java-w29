package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({ MethodArgumentNotValidException.class, HttpMessageNotReadableException.class })
    public ResponseEntity<ErrorDTO> handleValidationExceptions(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        String message = "Validation failed";
        int statusCode = HttpStatus.BAD_REQUEST.value();

        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException manve = (MethodArgumentNotValidException) ex;
            manve.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            message = "Validation error(s) occurred";
        } else if (ex instanceof HttpMessageNotReadableException) {
            message = "Request body is missing or malformed.";
            errors.put("request", message);
        }

        ErrorDTO error = new ErrorDTO(message, errors, statusCode);
        return ResponseEntity.status(statusCode).body(error);
    }
}
