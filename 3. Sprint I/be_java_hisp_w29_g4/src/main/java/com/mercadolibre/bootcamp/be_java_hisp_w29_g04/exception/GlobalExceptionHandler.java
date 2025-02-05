package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // NOT_FOUND: 404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    // CONFLICT: 409
    @ExceptionHandler(DuplicateFoundException.class)
    public ResponseEntity<String> handleDuplicateFoundException(DuplicateFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handleBadRequestException(ConflictException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    // BAD_REQUEST: 400
    @ExceptionHandler(InvalidRelationshipException.class)
    public ResponseEntity<String> invalidRelationshipException(InvalidRelationshipException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // BAD_REQUEST: 400
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageDto> handleBadRequestException(BadRequestException e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
