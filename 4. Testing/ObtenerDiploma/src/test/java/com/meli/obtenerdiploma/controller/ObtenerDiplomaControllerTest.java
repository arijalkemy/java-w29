package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    @DisplayName("Happy path analyze scores")
    void analyzeScoresTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",10.0));
        StudentDTO student = new StudentDTO(1L,
                "Pepe","El alumno Pepe ha obtenido un promedio de 10. Felicitaciones!",
                10.0,subjetc);
        when(service.analyzeScores(1L)).thenReturn(student);

        var actual = controller.analyzeScores(1L);

        assertEquals(student, actual);
    }


}
