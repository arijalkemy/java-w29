package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaExceptionControllerTest {
    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    ObtenerDiplomaExceptionController controller;

    @Test
    void handleGlobalExceptionsTest(){
        ObtenerDiplomaException exception = new ObtenerDiplomaException("Mensaje", HttpStatus.BAD_REQUEST);
        ResponseEntity<ErrorDTO> expected = new ResponseEntity<>(exception.getError(), exception.getStatus());

        var actual = controller.handleGlobalExceptions(exception);

        assertEquals(expected, actual);
    }

    @Test
    void handleValidationExceptionsMethodArgumentNotValidExceptionTest(){
        FieldError fieldError = mock(FieldError.class);
        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, bindingResult);
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", "mensaje");

        when(fieldError.getDefaultMessage()).thenReturn("mensaje");
        when(bindingResult.getFieldError()).thenReturn(fieldError);

        ResponseEntity<ErrorDTO> expected = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

        var actual = controller.handleValidationExceptions(exception);

        assertEquals(expected, actual);
    }

    @Test
    void handleValidationExceptionsHttpMessageNotReadableExceptionTest(){
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("mensaje");
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", "mensaje");

        ResponseEntity<ErrorDTO> expected = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

        var actual = controller.handleValidationExceptions(exception);

        assertEquals(expected, actual);
    }
}