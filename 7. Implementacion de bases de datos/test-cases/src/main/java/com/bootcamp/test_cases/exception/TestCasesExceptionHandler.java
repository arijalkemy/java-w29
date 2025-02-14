package com.bootcamp.test_cases.exception;

import com.bootcamp.test_cases.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class TestCasesExceptionHandler {

    @ExceptionHandler(exception = RuntimeException.class)
    public ResponseEntity<ErrorDto> handleTestCaseNotFound(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(e.getMessage()));
    }

    @ExceptionHandler(exception = DateTimeParseException.class)
    public ResponseEntity<ErrorDto> handleNotValidDateException(Exception e){
        return ResponseEntity.badRequest().body(new ErrorDto(e.getMessage()));
    }
}
