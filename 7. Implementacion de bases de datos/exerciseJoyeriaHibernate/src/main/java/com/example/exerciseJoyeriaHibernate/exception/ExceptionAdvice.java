package com.example.exerciseJoyeriaHibernate.exception;

import com.example.exerciseJoyeriaHibernate.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(NotFoundExecption.class)
    public ResponseEntity<ExceptionDto>NotFoundExecption(NotFoundExecption e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
