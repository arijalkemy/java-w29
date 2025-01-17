package meli.linktacker.exception;

import meli.linktacker.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<?> invalidUrl(InvalidUrlException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorDto,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> notFoundException(NotFoundException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
