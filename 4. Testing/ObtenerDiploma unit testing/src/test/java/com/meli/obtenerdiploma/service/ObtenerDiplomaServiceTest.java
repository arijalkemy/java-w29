package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresTest(){
        //arrange
        Long studentId = 1L;
        SubjectDTO math = new SubjectDTO("Matemáticas", 8.0);
        SubjectDTO history = new SubjectDTO("Historia", 10.0);
        StudentDTO student = new StudentDTO();
        student.setSubjects(Arrays.asList(math, history));
        student.setId(studentId);
        student.setStudentName("Juan Pérez");

        //act
        Mockito.when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO obtained = obtenerDiplomaService.analyzeScores(studentId);
        System.out.println(obtained.getMessage());

        //assert
        Assertions.assertEquals(9L, obtained.getAverageScore());
        Assertions.assertEquals("El alumno Juan Pérez ha obtenido un promedio de 9. Puedes mejorar.", obtained.getMessage());
    }

    @Test
    void analyzeScoresTestgreaterthan9(){
        //arrange
        Long studentId = 1L;
        SubjectDTO math = new SubjectDTO("Matemáticas", 8.0);
        SubjectDTO history = new SubjectDTO("Historia", 10.0);
        SubjectDTO history2 = new SubjectDTO("Historia 2", 12.0);
        StudentDTO student = new StudentDTO();
        student.setSubjects(Arrays.asList(math, history,history2));
        student.setId(studentId);
        student.setStudentName("Juan Pérez");

        //act
        Mockito.when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO obtained = obtenerDiplomaService.analyzeScores(studentId);
        System.out.println(obtained.getMessage());

        //assert
        Assertions.assertEquals(10L, obtained.getAverageScore());
        Assertions.assertEquals("El alumno Juan Pérez ha obtenido un promedio de 10. Felicitaciones!", obtained.getMessage());
    }


}
