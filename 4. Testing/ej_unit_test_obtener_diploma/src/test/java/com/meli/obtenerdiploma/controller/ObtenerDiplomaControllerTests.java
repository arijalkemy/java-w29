package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @Test
    public void successfulAnalyzeScores(){
        // ARRANGE
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Daniel");
        student.setAverageScore(6.0);
        student.setMessage("El alumno Daniel ha obtenido un promedio de 6. Puedes mejorar.");
        Mockito.when(obtenerDiplomaService.analyzeScores(any())).thenReturn(student);
        // ACT
        StudentDTO serviceStudent = controller.analyzeScores(9999L);
        // ASSERT
        assertEquals(6L, student.getAverageScore());
        assertEquals("El alumno Daniel ha obtenido un promedio de 6. Puedes mejorar.", student.getMessage());
    }

}
