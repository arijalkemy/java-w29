package meli.ejercicio.exceptions;

import meli.ejercicio.dto.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerProject {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDTO> handleException(NotFoundException ex) {
        MessageDTO messageDTO = new MessageDTO(ex.getMessage());
        return ResponseEntity.status(404).body(messageDTO);
    }
}
