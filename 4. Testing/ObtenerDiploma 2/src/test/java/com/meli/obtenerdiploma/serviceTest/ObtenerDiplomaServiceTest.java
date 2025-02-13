package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analyze scores test - Great score")
    public void shouldAnalyzeGreatScores() {
        // Arrange
        StudentDTO expectedStudent = TestUtils.getStudentWithGreatGrades();
        Mockito.when(studentDAO.findById(expectedStudent.getId())).thenReturn(expectedStudent);

        // Act
        StudentDTO actualStudent = obtenerDiplomaService.analyzeScores(expectedStudent.getId());

        // Assert
        Assertions.assertEquals(expectedStudent.getId(), actualStudent.getId());
        Assertions.assertEquals(expectedStudent.getStudentName(), actualStudent.getStudentName());
        Assertions.assertEquals(expectedStudent.getMessage(), actualStudent.getMessage());
        Assertions.assertEquals(expectedStudent.getAverageScore(), actualStudent.getAverageScore());
        Assertions.assertEquals(expectedStudent.getSubjects(), actualStudent.getSubjects());
    }

    @Test
    @DisplayName("Analyze scores test - Mediocre score")
    public void shouldAnalyzeMediocreScores() {
        // Arrange
        StudentDTO expectedStudent = TestUtils.getStudentWithMediocreGrades();
        Mockito.when(studentDAO.findById(expectedStudent.getId())).thenReturn(expectedStudent);

        // Act
        StudentDTO actualStudent = obtenerDiplomaService.analyzeScores(expectedStudent.getId());

        // Assert
        Assertions.assertEquals(expectedStudent.getId(), actualStudent.getId());
        Assertions.assertEquals(expectedStudent.getStudentName(), actualStudent.getStudentName());
        Assertions.assertEquals(expectedStudent.getMessage(), actualStudent.getMessage());
        Assertions.assertEquals(expectedStudent.getAverageScore(), actualStudent.getAverageScore());
        Assertions.assertEquals(expectedStudent.getSubjects(), actualStudent.getSubjects());
    }
}
