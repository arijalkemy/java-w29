package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    //Ejercicio 2
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO studentHighScore;
    private StudentDTO studentLowScore;

    @BeforeEach
    void setUp() {
        studentHighScore = new StudentDTO(1L, "Juan Pérez", "", 0.0,
                List.of(new SubjectDTO("Matemáticas", 10.0), new SubjectDTO("Historia", 9.5)));

        studentLowScore = new StudentDTO(2L, "Ana López", "", 0.0,
                List.of(new SubjectDTO("Matemáticas", 6.0), new SubjectDTO("Historia", 7.0)));
    }

    @Test
    @DisplayName("Analisis de Score con promedio mayor a 9")
    void analyzeScores_Congratulation() {
        when(studentDAO.findById(1L)).thenReturn(studentHighScore);

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(9.75, result.getAverageScore());
        assertTrue(result.getMessage().contains("Felicitaciones!"));

    }

    @Test
    @DisplayName("Analisis de Score con promedio menor a 9")
    void analyzeScores_CanImprove() {
        when(studentDAO.findById(2L)).thenReturn(studentLowScore);

        StudentDTO result = obtenerDiplomaService.analyzeScores(2L);

        assertEquals(6.5, result.getAverageScore());
        assertTrue(result.getMessage().contains("Puedes mejorar."));

    }

    @Test
    @DisplayName("Analisis de Score con alumno no encontrado")
    void analyzeScores_StudentNotFound_ShouldThrowException() {
        when(studentDAO.findById(99L)).thenThrow(new StudentNotFoundException(99L));

        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(99L));
    }
}