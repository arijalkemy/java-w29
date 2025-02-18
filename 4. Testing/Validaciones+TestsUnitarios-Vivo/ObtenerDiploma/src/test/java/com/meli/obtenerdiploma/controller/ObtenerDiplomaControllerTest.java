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
    IObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("analyzeScores")
    void analyzeScores(){
        StudentDTO studentMock = new StudentDTO(3L,"Nestor", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        ));
        when(obtenerDiplomaController.analyzeScores(3L)).thenReturn(studentMock);
        StudentDTO result = obtenerDiplomaController.analyzeScores(3L);
        assertEquals(3L,result.getId());

    }
}
