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
        ErrorDTO errorDTO = new ErrorDTO("name", "message");
        ObtenerDiplomaException obtenerDiplomaException =
                new ObtenerDiplomaException(errorDTO.getName(), HttpStatus.BAD_REQUEST);
        ResponseEntity<ErrorDTO> errorDTOResponseEntity =
                obtenerDiplomaExceptionController.handleGlobalExceptions(obtenerDiplomaException);
        assertEquals(400, errorDTOResponseEntity.getStatusCodeValue());

    }

    @Test
    void handleValidationExceptionsWhenMethodArgumentNotValidException() {
        //arrange
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError = new FieldError("objectName", "field", "Default message");
        when(bindingResult.getFieldError()).thenReturn(fieldError);
        MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(
                mock(MethodParameter.class), bindingResult);
        //act
        ResponseEntity<ErrorDTO> errorDTOResponseEntity =
                obtenerDiplomaExceptionController.handleValidationExceptions(methodArgumentNotValidException);
        //assert
        assertEquals(400, errorDTOResponseEntity.getStatusCodeValue());
    }


    @Test
    void testHandleValidationExceptionsWhenHttpMessageNotReadableException() {
        HttpInputMessage httpInputMessage = mock(HttpInputMessage.class);
        HttpMessageNotReadableException httpMessageNotReadableException =
                new HttpMessageNotReadableException("", httpInputMessage);
        ResponseEntity<ErrorDTO> errorDTOResponseEntity =
                obtenerDiplomaExceptionController.handleValidationExceptions(httpMessageNotReadableException);
        assertEquals(400, errorDTOResponseEntity.getStatusCodeValue());
    }
}