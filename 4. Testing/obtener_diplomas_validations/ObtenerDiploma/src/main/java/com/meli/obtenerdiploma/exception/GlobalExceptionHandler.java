package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.ErrorDetailDto;
import com.meli.obtenerdiploma.dto.ExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> errores = e.getBindingResult().getFieldErrors();
        List<ErrorDetailDto> errorDetails = errores.stream()
                .map(error -> new ErrorDetailDto(
                        error.getField(),
                        error.getDefaultMessage()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(new ExceptionDto(errorDetails, LocalDateTime.now()));
    }
}
