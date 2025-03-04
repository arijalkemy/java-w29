package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    //Ejercicio 4
    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    private StudentDTO student;

    @BeforeEach
    void setUp() {
        student = new StudentDTO(1L, "Juan Perez", "", 9.5,
                List.of(new SubjectDTO("Matemáticas", 10.0), new SubjectDTO("Historia", 9.0)));
    }

    @Test
    void analyzeScoresOkTest() {
        when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(student);
        StudentDTO result = obtenerDiplomaController.analyzeScores(1L);
        assertNotNull(result);
        assertEquals("Juan Perez", result.getStudentName());
        assertEquals(9.5, result.getAverageScore());
    }


    @Test
    void analyzeScoresNotFoundExceptionTest() {
        when(obtenerDiplomaService.analyzeScores(99L)).thenThrow(new StudentNotFoundException(99L));
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaController.analyzeScores(99L));
    }
}