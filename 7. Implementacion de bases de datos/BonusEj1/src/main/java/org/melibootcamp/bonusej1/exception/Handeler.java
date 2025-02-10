package org.melibootcamp.bonusej1.exception;

import org.melibootcamp.bonusej1.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handeler {

    @ExceptionHandler(GarmentNotFound.class)
    public ResponseEntity<MessageDto> handleGarmentNotFound(GarmentNotFound e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(GarmentAlreadyExist.class)
    public ResponseEntity<MessageDto> handleGarmentAlreadyExist(GarmentAlreadyExist e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(SaleNotFound.class)
    public ResponseEntity<MessageDto> handleSaleNotFound(SaleNotFound e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SaleAlreadyExist.class)
    public ResponseEntity<MessageDto> handleSaleAlreadyExist(SaleAlreadyExist e) {
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
            return new ResponseEntity<>(new MessageDto("BodyError"), HttpStatus.BAD_REQUEST);
    }
}
