package com.socialmeli.socialmeli.exception;

import com.socialmeli.socialmeli.dto.response.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDto> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDto(e.getMessage()));
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<MessageDto> handleAlreadyExistsException(AlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageDto(e.getMessage()));
    }

    @ExceptionHandler(IllegalActionException.class)
    public ResponseEntity<MessageDto> handleIllegalActionException(IllegalActionException e) {
        return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageDto> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
    }

    @ExceptionHandler(UserNotSellerException.class)
    public ResponseEntity<MessageDto> handleUserNotSellerException(UserNotSellerException e) {
        return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body(new MessageDto("Error parsing request body"));
    }
}
