package com.thiagoschreck.local.link_tracker.exception;

import com.thiagoschreck.local.link_tracker.dto.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(LinkIdNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> linkIdNotFoundException(Exception e) {
        return new ResponseEntity<>(new ErrorResponseDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ErrorResponseDTO> invalidLinkException(Exception e) {
        return new ResponseEntity<>(new ErrorResponseDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DisabledLinkException.class)
    public ResponseEntity<ErrorResponseDTO> disabledLinkException(Exception e) {
        return new ResponseEntity<>(new ErrorResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ErrorResponseDTO> invalidPasswordException(Exception e) {
        return new ResponseEntity<>(new ErrorResponseDTO(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
