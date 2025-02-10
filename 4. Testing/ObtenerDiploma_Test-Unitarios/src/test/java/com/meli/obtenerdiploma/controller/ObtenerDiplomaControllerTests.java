package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @Test
    public void successfulAnalyzeScores(){
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("David");
        student.setAverageScore(6.7);
        student.setMessage("Debes trabajar un poco mas duro.");
        Mockito.when(obtenerDiplomaService.analyzeScores(any())).thenReturn(student);
        // Act
        StudentDTO serviceStudent = controller.analyzeScores(9999L);
        // Assert
        assertEquals(6.7, student.getAverageScore());
        assertEquals("Debes trabajar un poco mas duro.", student.getMessage());
    }

}
