package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;
    private ObtenerDiplomaExceptionController obtenerDiplomaExceptionController;

    @BeforeEach
    public void setUp() {
        obtenerDiplomaExceptionController = new ObtenerDiplomaExceptionController();
    }

    @Test
    @DisplayName("analyzeScores with an existing Id")
    void testAnalyzeScores() {
        // Arrange
        Long studentId = 1L;

        StudentDTO expectedStudent = new StudentDTO(studentId, "Juan", null, null, null);

        // Act
//        given(obtenerDiplomaService.analyzeScores(anyLong())).willReturn(expectedStudent); // Se puede usar esta forma también
        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expectedStudent);

        StudentDTO result = obtenerDiplomaController.analyzeScores(studentId);

        // Assert
        assertEquals(expectedStudent, result, "El resultado no es el esperado.");

        verify(obtenerDiplomaService).analyzeScores(studentId);
    }

    @Test
    @DisplayName("analyzeScores with non existing Id")
    public void testAnalyzeScores_StudentNotFoundExceptionHandled() {
        // Arrange
        Long nonExistingId = 1L;

        when(obtenerDiplomaService.analyzeScores(nonExistingId))
                .thenThrow(new StudentNotFoundException(nonExistingId));

        // Act & assert
        try {
            obtenerDiplomaController.analyzeScores(nonExistingId);
        } catch (StudentNotFoundException e) {
            ErrorDTO errorDTO = e.getError();

            assertNotNull(errorDTO);
            assertEquals("El alumno con Id 1 no se encuetra registrado.", errorDTO.getDescription());

            ResponseEntity<ErrorDTO> responseEntity = obtenerDiplomaExceptionController.handleStudentNotFoundException(e);

            assertNotNull(responseEntity);
            assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
            assertNotNull(responseEntity.getBody());
            assertEquals("StudentNotFoundException", responseEntity.getBody().getName());
            assertNull(responseEntity.getBody().getDescription());
        }
    }
}


