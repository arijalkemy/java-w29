package com.example.blog_exercise.exception;


import com.example.blog_exercise.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFoundHandler(BlogNotFoundException exception){

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();

        errorResponseDto.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BlogAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> alreadyExistsHandler(BlogAlreadyExistsException exception){

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();

        errorResponseDto.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.CONFLICT);
    }
}