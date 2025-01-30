package com.meli.obtenerdiploma.service;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplonaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan Pérez");
        studentDTO.setSubjects(List.of(
                new SubjectDTO("Matemáticas", 9.0),
                new SubjectDTO("Historia", 8.0),
                new SubjectDTO("Ciencias", 10.0)
        ));
    }

    @Test
    void analyzeScoresTest() {
        Long studentId = 1L;

        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertNotNull(result);
        assertEquals("Juan Pérez", result.getStudentName());
        assertEquals(9.0, result.getAverageScore()); // (9+8+10) / 3
        assertTrue(result.getMessage().contains("Puedes mejorar."));

        verify(studentDAO, times(1)).findById(studentId);
    }

    @Test
    void testCalculateAverage() {
        Double average = obtenerDiplomaService.calculateAverage(studentDTO.getSubjects());
        assertEquals(9.0, average);
    }

    @Test
    void testGetGreetingMessage_HighScore() {
        String message = obtenerDiplomaService.getGreetingMessage("Ana", 9.5);
        assertEquals("El alumno Ana ha obtenido un promedio de 9,5. Felicitaciones!", message);
    }

    @Test
    void testGetGreetingMessage_LowScore() {
        String message = obtenerDiplomaService.getGreetingMessage("Carlos", 8.0);
        assertEquals("El alumno Carlos ha obtenido un promedio de 8. Puedes mejorar.", message);
    }

    @Test
    void analyzeScoresTest_HighScore() {
        studentDTO.setSubjects(List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Historia", 10.0),
                new SubjectDTO("Ciencias", 10.0)
        ));

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(10.0, result.getAverageScore());
        assertTrue(result.getMessage().contains("Felicitaciones!"));
    }
}
