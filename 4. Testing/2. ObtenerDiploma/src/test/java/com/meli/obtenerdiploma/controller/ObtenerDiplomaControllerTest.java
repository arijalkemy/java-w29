package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    @DisplayName("CU1 - Analyze scores test average ok")
    void analyzeScoresTestAverageOk() {
        Long id = 30L;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setAverageScore(9.5);
        StudentDTO response;

        when(service.analyzeScores(id)).thenReturn(studentDTO);

        response = controller.analyzeScores(id);

        assertNotNull(response);
        assertEquals(studentDTO.getAverageScore(), response.getAverageScore());
    }

    @Test
    @DisplayName("CU1 - Analyze scores test message ok")
    void analyzeScoresTestMessageOk() {
        Long id = 30L;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName("Nombre");
        studentDTO.setMessage("El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de 9,5. Felicitaciones!");
        StudentDTO response;

        when(service.analyzeScores(id)).thenReturn(studentDTO);

        response = controller.analyzeScores(id);

        assertNotNull(response);
        assertEquals(studentDTO.getMessage(), response.getMessage());
    }

    @Test
    @DisplayName("CU1 - Analyze scores test message better")
    void analyzeScoresTestMessageBetter() {
        Long id = 30L;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName("Nombre");
        studentDTO.setMessage("El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de 8,5. Puedes mejorar.");
        StudentDTO response;

        when(service.analyzeScores(id)).thenReturn(studentDTO);

        response = controller.analyzeScores(id);

        assertNotNull(response);
        assertEquals(studentDTO.getMessage(), response.getMessage());
    }
}