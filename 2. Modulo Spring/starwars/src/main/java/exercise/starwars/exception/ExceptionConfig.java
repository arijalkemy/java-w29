package exercise.starwars.exception;

import exercise.starwars.dto.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(CharacterNotFoundException.class)
    public ResponseEntity<?> notFoundExceptionHandler(CharacterNotFoundException exception){
        ErrorDto errorDto = new ErrorDto();

        errorDto.setMessage("EXCEPCIÓN: "+ exception.getMessage());

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> notFoundExceptionHandler(HttpMessageNotReadableException exception){
        ErrorDto errorDto = new ErrorDto();

        errorDto.setMessage("EXCEPCIÓN: "+ exception.getMessage());

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
