package spring_recap_p2.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {
  
  @ExceptionHandler
  public ResponseEntity<?> IllegalArgumentExceptionHandler(IllegalArgumentException exception){
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler
  public ResponseEntity<?> NoSuchElementExceptionHandler(NoSuchElementException exception){
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<?> IncorrectPasswordExceptionHandler(IncorrectPasswordException exception){
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
