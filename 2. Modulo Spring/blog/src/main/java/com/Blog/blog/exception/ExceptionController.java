package com.Blog.blog.exception;

import com.Blog.blog.dto.AddBlogDto;
import com.Blog.blog.dto.ErrorDto;
import com.Blog.blog.dto.ResponseBlogDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> conflicException(ConflictException e){
        return new ResponseEntity<>(new ErrorDto(e.getMessage()),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e){
        return new ResponseEntity<>(new ErrorDto(e.getMessage()),HttpStatus.NOT_FOUND);
    }

}
