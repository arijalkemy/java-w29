package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
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
class ObtenerDiplomaExceptionControllerTest {


    @InjectMocks
    ObtenerDiplomaExceptionController obtenerDiplomaExceptionController;

    @Test
    void handleGlobalExceptions() {
        //arrange
        ErrorDTO errorDTO = new ErrorDTO("name", "message");
        ObtenerDiplomaException obtenerDiplomaException = new ObtenerDiplomaException(errorDTO.getName(), HttpStatus.BAD_REQUEST);

        //act
        ResponseEntity<ErrorDTO> errorDTOResponseEntity = obtenerDiplomaExceptionController.handleGlobalExceptions(obtenerDiplomaException);

        //assert
        assertEquals(400, errorDTOResponseEntity.getStatusCodeValue());

    }

    @Test
    void handleValidationExceptions() {
        //arrange
        BindingResult bindingResult = mock(BindingResult.class);
        MethodParameter methodParameter = mock(MethodParameter.class);

        FieldError fieldError = new FieldError("", "", "default");
        when(bindingResult.getFieldError()).thenReturn(fieldError);
        MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(methodParameter, bindingResult);

        //act
        ResponseEntity<ErrorDTO> errorDTOResponseEntity = obtenerDiplomaExceptionController.handleValidationExceptions(methodArgumentNotValidException);

        //assert
        assertEquals(400, errorDTOResponseEntity.getStatusCodeValue());

    }

    @Test
    void testHandleValidationExceptions() {
        //arrange
        HttpInputMessage httpInputMessage = mock(HttpInputMessage.class);
        HttpMessageNotReadableException httpMessageNotReadableException = new HttpMessageNotReadableException("", httpInputMessage);

        //act
        ResponseEntity<ErrorDTO> errorDTOResponseEntity = obtenerDiplomaExceptionController.handleValidationExceptions(httpMessageNotReadableException);

        //assert
        assertEquals(400, errorDTOResponseEntity.getStatusCodeValue());
    }
}