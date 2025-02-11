package com.bootcamp.be_java_hisp_w29_g07.exception;

import com.bootcamp.be_java_hisp_w29_g07.dto.ExceptionDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.FieldErrorDetailDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.ValidationExceptionDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.List;

/**
 * This class handles exceptions globally for the application.
 * It defines methods to manage specific exceptions and returns appropriate HTTP responses.
 */
@ControllerAdvice
public class ExceptionController {

    /**
     * Handles NotFoundException and returns a 404 NOT FOUND response.
     *
     * @param e the exception thrown when a resource is not found
     * @return the response entity with error details and HTTP status 404
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleNotFoundException(NotFoundException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles ConflictException and returns a 409 CONFLICT response.
     *
     * @param e the exception thrown when a conflict occurs
     * @return the response entity with error details and HTTP status 409
     */
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionDTO> handleConflictException(ConflictException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.CONFLICT);
    }

    /**
     * Handles BadRequestException and returns a 400 BAD REQUEST response.
     *
     * @param e the exception thrown when a bad request is made
     * @return the response entity with error details and HTTP status 400
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> handleBadRequestException(BadRequestException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    // Maneja las excepciones generadas al validar objetos (por ejemplo, @RequestBody)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<FieldErrorDetailDTO> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new FieldErrorDetailDTO(error.getField(), error.getDefaultMessage()))
                .toList();

        ValidationExceptionDTO validationError = new ValidationExceptionDTO(
                "Validation failed",
                errors
        );
        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }

    //Maneja las excepciones generadas al validar parámetros del método (por ejemplo, @PathVariable)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex) {
        List<FieldErrorDetailDTO> errors = ex.getConstraintViolations()
                .stream()
                .map(error -> new FieldErrorDetailDTO(
                        error.getPropertyPath().toString(),
                        error.getMessage()))
                .toList();

        ValidationExceptionDTO validationError = new ValidationExceptionDTO(
                "Validation failed",
                errors
        );

        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }



}

