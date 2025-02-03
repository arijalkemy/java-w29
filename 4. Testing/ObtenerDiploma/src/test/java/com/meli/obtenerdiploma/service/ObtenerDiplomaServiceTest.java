package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void averageScoreCalculated(){
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        obtenerDiplomaService.analyzeScores(studentDTO.getId());

        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(6.0, studentDTO.getAverageScore());
    }

    @Test
    public void messageGreaterThan9(){
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        studentDTO.getSubjects().forEach(s -> s.setScore(9.5));
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        obtenerDiplomaService.analyzeScores(studentDTO.getId());

        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals("El alumno Andrés ha obtenido un promedio de 9,5. Felicitaciones!", studentDTO.getMessage());

    }

    @Test
    public void messageLessThan9(){
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        obtenerDiplomaService.analyzeScores(studentDTO.getId());

        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals("El alumno Andrés ha obtenido un promedio de 6. Puedes mejorar.", studentDTO.getMessage());

    }
}
