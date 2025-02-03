package com.meli.obtenerdiploma.controllerTest;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    final static Long ID = 1L;
    final static String NAME = "Jhon";
    final static Double AVERAGE_GREATER_THAN_NINE = 9.55;
    final static String MSG_AVERAGE_GREATER_THAN_NINE = "El alumno " + NAME +
            " ha obtenido un promedio de " + AVERAGE_GREATER_THAN_NINE + ". Felicitaciones!";
    public static List<SubjectDTO> subjects;
    public static StudentDTO student;

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresTest(){
        subjects = List.of(
                new SubjectDTO("Matematicas", 9.5),
                new SubjectDTO("Fisica", 9.6)
        );
        StudentDTO student = new StudentDTO(ID, NAME, MSG_AVERAGE_GREATER_THAN_NINE, AVERAGE_GREATER_THAN_NINE, subjects);
        Mockito.when(service.analyzeScores(ID)).thenReturn(student);

        StudentDTO obtained = obtenerDiplomaController.analyzeScores(ID);

        Assertions.assertNotNull(obtained);
        Assertions.assertEquals(student, obtained);
        Assertions.assertEquals(ID, obtained.getId());
    }


}
