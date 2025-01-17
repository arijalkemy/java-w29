package com.meli.blog.exception;

import com.meli.blog.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
        ResponseDto<Object> responseDto = new ResponseDto<>(e.getMessage(), HttpStatus.BAD_REQUEST.value(), false);
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        ResponseDto<Object> responseDto = new ResponseDto<>(e.getMessage(), HttpStatus.NOT_FOUND.value(), false);
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }
}
