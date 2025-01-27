package sprint1.be_java_hisp_w29_g9.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}