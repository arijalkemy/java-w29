package com.meli.obtenerdiploma.serviceTest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.OverridesAttribute;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    final static Long ID = 1L;
    final static String NAME = "Jhon";
    final static Double AVERAGE_GREATER_THAN_NINE = 9.55;
    final static Double AVERAGE_LESS_THAN_OR_EQUAL_TO_NINE = 7.05;
    final static String MSG_AVERAGE_GREATER_THAN_NINE = "El alumno " + NAME +
            " ha obtenido un promedio de " + AVERAGE_GREATER_THAN_NINE + ". Felicitaciones!";
    final static  String MSG_AVERAGE_LESS_THAN_OR_EQUAL_TO_NINE = "El alumno " + NAME +
            " ha obtenido un promedio de " + AVERAGE_LESS_THAN_OR_EQUAL_TO_NINE + ". Puedes mejorar.";
    public static List<SubjectDTO> subjects;
    public static StudentDTO student;

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    @Test
    public void averageGreaterThanNine(){
        subjects = List.of(
                new SubjectDTO("Matematicas", 9.5),
                new SubjectDTO("Fisica", 9.6)
        );

        student = new StudentDTO(ID, NAME, "", 0.0, subjects);

        Mockito.when(studentDAO.findById(ID)).thenReturn(student);

        StudentDTO obtained = obtenerDiplomaService.analyzeScores(ID);

        Assertions.assertNotNull(obtained);
        Assertions.assertEquals(AVERAGE_GREATER_THAN_NINE, obtained.getAverageScore());
        Assertions.assertEquals(MSG_AVERAGE_GREATER_THAN_NINE, obtained.getMessage());
    }

    @Test
    public void averageLessThanOrEqualToNine(){
        subjects = List.of(
                new SubjectDTO("Matematicas", 7.5),
                new SubjectDTO("Fisica", 6.6)
        );

        student = new StudentDTO(ID, NAME, "", 0.0, subjects);

        Mockito.when(studentDAO.findById(ID)).thenReturn(student);

        StudentDTO obtained = obtenerDiplomaService.analyzeScores(ID);

        Assertions.assertNotNull(obtained);
        Assertions.assertEquals(AVERAGE_LESS_THAN_OR_EQUAL_TO_NINE, obtained.getAverageScore());
        Assertions.assertEquals(MSG_AVERAGE_LESS_THAN_OR_EQUAL_TO_NINE, obtained.getMessage());
    }
}
