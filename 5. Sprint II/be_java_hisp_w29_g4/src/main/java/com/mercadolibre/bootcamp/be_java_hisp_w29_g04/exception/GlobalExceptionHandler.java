package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // NOT_FOUND: 404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDto> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    // CONFLICT: 409
    @ExceptionHandler(DuplicateFoundException.class)
    public ResponseEntity<MessageDto> handleDuplicateFoundException(DuplicateFoundException e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<MessageDto> handleBadRequestException(ConflictException e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.CONFLICT);
    }

    // BAD_REQUEST: 400
    @ExceptionHandler(InvalidRelationshipException.class)
    public ResponseEntity<MessageDto> invalidRelationshipException(InvalidRelationshipException e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // BAD_REQUEST: 400
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageDto> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // BAD_REQUEST: 400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageDto> handleBadRequestException(BadRequestException e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // BAD_REQUEST: 400
    @ExceptionHandler(InvalidOrderException.class)
    public ResponseEntity<MessageDto> handleBadRequestException(InvalidOrderException e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
