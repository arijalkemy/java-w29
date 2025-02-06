package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    @DisplayName("Ejercicio2")
    void analyzeScoresOkTest(){
        // Arrange
        Long studentId = 1L;
        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Matematica", 9.5),
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Historia", 7.5)
        );
        StudentDTO student = new StudentDTO(studentId, "Juan", null, null, subjects);
        when(studentDAO.findById(studentId)).thenReturn(student);
        //ACT
        StudentDTO result = service.analyzeScores(studentId);
        //Assert
        assertNotNull(result);
        assertEquals("Juan", result.getStudentName());
        assertEquals(8.33, result.getAverageScore(), 0.01);
        assertEquals("El alumno Juan ha obtenido un promedio de 8,33. Puedes mejorar.", result.getMessage());
        verify(studentDAO).findById(studentId);
    }

    @Test
    void analyzeScoresShouldThrowExceptionWhenStudentNotFound(){
        //Arrenge
        Long studentId = 2L;
        when(studentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId));

        //act y  assert
        assertThrows(StudentNotFoundException.class, ()-> service.analyzeScores(studentId));
        verify(studentDAO).findById(studentId);
    }
    @Test
    @DisplayName("calcular correctamente el promedio y generar mensaje de Honores")
    void analyzeScoresShouldGenerateHonorsMessage(){
        //Arrenge
        Long studentId = 3L;
        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Lengua", 9.5),
                new SubjectDTO("Historia", 9.8)
        );
        StudentDTO student = new StudentDTO(studentId, "Felipe", null, null, subjects);
        when(studentDAO.findById(studentId)).thenReturn(student);

        //act
        StudentDTO result = service.analyzeScores(studentId);

        //assert
        assertNotNull(result);
        assertEquals("Felipe", result.getStudentName());
        assertEquals(9.77, result.getAverageScore(), 0.01);
        assertEquals("El alumno Felipe ha obtenido un promedio de 9,77. Felicitaciones!", result.getMessage());
        verify(studentDAO).findById(studentId);
    }

}
