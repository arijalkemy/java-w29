package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("CU1 - Analyze student score average OK")
    void analyzeScoresTestOkAverageScore() {
        Long studentId = 15L;
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Materia1", 10.0));
        subjectDTOS.add(new SubjectDTO("Materia2", 9.0));
        StudentDTO response = new StudentDTO(studentId, "Nombre", "Apellido", 9.5, subjectDTOS);
        when(iStudentDAO.findById(studentId)).thenReturn(response);

        StudentDTO serviceResponse = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals(serviceResponse.getAverageScore(), response.getAverageScore());
    }

    @Test
    @DisplayName("CU1 - Analyze student score message OK")
    void analyzeScoresTestOkMessage() {
        Long studentId = 15L;
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Materia1", 10.0));
        subjectDTOS.add(new SubjectDTO("Materia2", 9.0));
        StudentDTO response = new StudentDTO(studentId, "Nombre", "Apellido", 9.50, subjectDTOS);
        String messageExpected = "El alumno " + response.getStudentName() + " ha obtenido un promedio de 9,5. Felicitaciones!";
        when(iStudentDAO.findById(studentId)).thenReturn(response);

        StudentDTO serviceResponse = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals(messageExpected, serviceResponse.getMessage());
    }

    @Test
    @DisplayName("CU1 - Analyze student score message better score")
    void analyzeScoresTestBetterMessage() {
        Long studentId = 15L;
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Materia1", 8.0));
        subjectDTOS.add(new SubjectDTO("Materia2", 9.0));
        StudentDTO response = new StudentDTO(studentId, "Nombre", "Apellido", 8.50, subjectDTOS);
        String messageExpected = "El alumno " + response.getStudentName() + " ha obtenido un promedio de 8,5. Puedes mejorar.";
        when(iStudentDAO.findById(studentId)).thenReturn(response);

        StudentDTO serviceResponse = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals(messageExpected, serviceResponse.getMessage());
    }

    @Test
    @DisplayName("CU1 - Student not found")
    void studentNotFoundTest() {
        StudentDTO response = new StudentDTO();
        when(iStudentDAO.findById(0L)).thenReturn(response);

        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(0L));
    }
}