package com.bootcamp.link_tracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@ControllerAdvice
public class LinkExceptionHandler {

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<String> handleLinkNotFoundException(LinkNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(exception = {MalformedURLException.class, URISyntaxException.class})
    public ResponseEntity<String> handleBadLinkException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid URL");
    }
}
