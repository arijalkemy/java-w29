package sprint1.be_java_hisp_w29_g9.exceptions;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sprint1.be_java_hisp_w29_g9.dtos.exception.ExceptionDto;

@ControllerAdvice
public class ExceptionController {
  
  @ExceptionHandler
    public ResponseEntity<ExceptionDto> notFound(NotFoundException e){
      ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
      return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<ExceptionDto> badRequest(BadRequestException e){
    ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
    return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler
  public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
    return ResponseEntity.badRequest().body(exception.getBindingResult().getFieldErrors().stream()
      .collect(Collectors.toMap(
        error -> error.getField(), 
        error -> error.getDefaultMessage()
      )));
  }

  @ExceptionHandler
  public ResponseEntity<?> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException exception){
    Throwable rootCause = exception.getRootCause();
    String message = (rootCause != null) ? rootCause.getMessage() : "Unexpected error";
    return ResponseEntity.unprocessableEntity().body(message);
  }
}