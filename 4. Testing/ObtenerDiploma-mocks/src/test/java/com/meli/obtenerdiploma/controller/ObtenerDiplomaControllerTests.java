package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService diplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    private final Long USER_ID = 1L;
    private final String STUDENT_NAME = "Matías";
    private final String STUDENT_MESSAGE = "Mensaje descriptivo";
    private final Double STUDENT_SCORE = 9.75;

    /* Inmutable */
    private final List<SubjectDTO> SUBJECTS_APPROVED = List.of(
            new SubjectDTO("Subject 1", 9.5),
            new SubjectDTO("Subject 2", 10.0));

    @Test
    public void analyzeScores_ValidStudent_ReturnsCompleteStudentInfo() {
        // Arrange
        StudentDTO expected = new StudentDTO(USER_ID, STUDENT_NAME, STUDENT_MESSAGE, STUDENT_SCORE, SUBJECTS_APPROVED);
        when(diplomaService.analyzeScores(USER_ID)).thenReturn(expected);

        // Act
        StudentDTO result = obtenerDiplomaController.analyzeScores(USER_ID);

        // Assert
        assertNotNull(result);
        assertEquals(expected.getId(), result.getId());
        assertEquals(expected.getStudentName(), result.getStudentName());
        assertEquals(expected.getMessage(), result.getMessage());
        assertEquals(expected.getAverageScore(), result.getAverageScore());
        assertEquals(expected.getSubjects().size(), result.getSubjects().size());

        // Verificar que las materias son las mismas
        assertEquals(SUBJECTS_APPROVED, result.getSubjects());

        // Verificar que el servicio fue llamado exactamente una vez
        verify(diplomaService, times(1)).analyzeScores(USER_ID);
    }

    @Test
    public void analyzeScores_NonExistentStudent_ReturnsNull() {
        // Arrange
        when(diplomaService.analyzeScores(999L)).thenReturn(null);

        // Act
        StudentDTO result = obtenerDiplomaController.analyzeScores(999L);

        // Assert
        assertNull(result);
        verify(diplomaService, times(1)).analyzeScores(999L);
    }
}