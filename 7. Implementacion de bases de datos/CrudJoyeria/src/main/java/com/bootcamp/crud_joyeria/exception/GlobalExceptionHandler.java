package com.bootcamp.crud_joyeria.exception;

import com.bootcamp.crud_joyeria.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(JewelNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleJewelNotFoundException(JewelNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(e.getMessage()));
    }
}
