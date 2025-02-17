package com.bootcampw29.qa_testers.exception;

import com.bootcampw29.qa_testers.dto.response.ErrorResponseDTO;
import com.bootcampw29.qa_testers.dto.response.ValidationErrorDTO;
import com.bootcampw29.qa_testers.dto.response.ValidationErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(NotFoundException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<ValidationErrorDTO> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationErrorDTO(error.getField(), error.getDefaultMessage()))
                .toList();

        ValidationErrorResponseDTO validationError = new ValidationErrorResponseDTO(
                "Validation failed",
                errors
        );
        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
}
