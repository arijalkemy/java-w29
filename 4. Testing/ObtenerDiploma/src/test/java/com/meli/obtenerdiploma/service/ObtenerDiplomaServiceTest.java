package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScores() {
        //Arrange
        StudentDTO returned = new StudentDTO();
        returned.setId(1L);
        returned.setStudentName("Pepe");
        returned.setSubjects(List.of(
                new SubjectDTO("Mates",0.0),
                new SubjectDTO("Ingles",10.0)
        ));
        StudentDTO expected = new StudentDTO();
        expected.setId(1L);
        expected.setStudentName("Pepe");
        expected.setMessage("El alumno Pepe ha obtenido un promedio de 5. Puedes mejorar.");
        expected.setSubjects(List.of(
                new SubjectDTO("Mates",0.0),
                new SubjectDTO("Ingles",10.0)
        ));
        expected.setAverageScore(5.0);
        when(studentDAO.findById(1L)).thenReturn(returned);
        //Act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(1L);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void analyzeScoresHonorTest() {
        //Arrange
        StudentDTO returned = new StudentDTO();
        returned.setId(1L);
        returned.setStudentName("Pepe");
        returned.setSubjects(List.of(
                new SubjectDTO("Mates",10.0),
                new SubjectDTO("Ingles",10.0)
        ));
        StudentDTO expected = new StudentDTO();
        expected.setId(1L);
        expected.setStudentName("Pepe");
        expected.setMessage("El alumno Pepe ha obtenido un promedio de 10. Felicitaciones!");
        expected.setSubjects(List.of(
                new SubjectDTO("Mates",10.0),
                new SubjectDTO("Ingles",10.0)
        ));
        expected.setAverageScore(10.0);
        when(studentDAO.findById(1L)).thenReturn(returned);
        //Act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(1L);
        //Assert
        assertEquals(expected, actual);
    }
}
