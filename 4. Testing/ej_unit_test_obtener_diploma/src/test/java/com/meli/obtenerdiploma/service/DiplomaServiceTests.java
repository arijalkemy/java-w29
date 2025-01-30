package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class DiplomaServiceTests {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService service;

    @Test
    public void successfulAnalyzeScores(){
        // ARRANGE
        Mockito.when(studentDAO.findById(any())).thenReturn(TestUtilsGenerator.getStudentWith3Subjects("Daniel"));
        // ACT
        StudentDTO student = service.analyzeScores(9999L);
        // ASSERT
        assertEquals(6L, student.getAverageScore());
        assertEquals("El alumno Daniel ha obtenido un promedio de 6. Puedes mejorar.", student.getMessage());
    }
}
