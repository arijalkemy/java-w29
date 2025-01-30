package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaExceptionControllerTests {

    @InjectMocks
    ObtenerDiplomaExceptionController exceptionController;

    @Test
    void handleGlobalExceptions_ReturnsCorrectErrorResponse() {
        // Arrange
        String expectedName = ObtenerDiplomaException.class.getSimpleName();
        String expectedMessage = "Test error description";
        HttpStatus expectedStatus = HttpStatus.BAD_REQUEST;
        ObtenerDiplomaException exception = new ObtenerDiplomaException(expectedMessage, expectedStatus);

        // Act
        ResponseEntity<ErrorDTO> response = exceptionController.handleGlobalExceptions(exception);

        // Assert
        assertNotNull(response);
        assertEquals(expectedStatus, response.getStatusCode());
        assertEquals(expectedName, response.getBody().getName());
        assertEquals(expectedMessage, response.getBody().getDescription());
    }

    @Test
    void handleHttpMessageNotReadableException_ReturnsCorrectErrorResponse() {
        // Arrange
        String errorMessage = "Message not readable";
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException(errorMessage);

        // Act
        ResponseEntity<ErrorDTO> response = exceptionController.handleValidationExceptions(exception);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("HttpMessageNotReadableException", response.getBody().getName());
        assertTrue(response.getBody().getDescription().contains(errorMessage));
    }
}
