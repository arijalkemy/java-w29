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

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> unauthorizedException(UnauthorizedException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
