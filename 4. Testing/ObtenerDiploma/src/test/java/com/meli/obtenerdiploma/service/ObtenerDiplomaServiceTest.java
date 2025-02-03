package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.StudentTestFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;


    @Test
    void givenStudent_whenAnalyzeScores_thenCalculateCorrectAverage() {
        Long studentId = 1L;
        StudentDTO student = StudentTestFactory.buildStudentWithSubjects(studentId);
        when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals(6.5, result.getAverageScore());
    }

    @Test
    void givenStudentWithHighScores_whenAnalyzeScores_thenGenerateCongratulationsMessage() {

        Long studentId = 1L;
        StudentDTO student = StudentTestFactory.buildHighAverageStudent(studentId);
        when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals("El alumno Andres ha obtenido un promedio de 9.5. Felicitaciones!", result.getMessage());

    }

    @Test
    void giveStudentWithLowScores_whenAnalyzeScores_thenGenerateMotivationMessage() {
        Long studentId = 2L;
        StudentDTO student = StudentTestFactory.buildLowAverageStudent(studentId);
        when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals("El alumno Pepe ha obtenido un promedio de 4.5. Puedes mejorar.", result.getMessage());
    }

    @Test
    void givenNonExistingStudent_whenAnalyzeScores_thenThrowException() {
        Long studentId = 99L;
        when(studentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId));
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(studentId));
    }


}
