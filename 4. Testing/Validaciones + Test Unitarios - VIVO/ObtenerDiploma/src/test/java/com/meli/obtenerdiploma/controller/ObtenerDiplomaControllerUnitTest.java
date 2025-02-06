package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerUnitTest {

    @Mock
    private ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Should return average score test")
    public void shouldReturnAverageScoreTest() {
        // Arrange
        Long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentId);
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(studentDTO);

        // Act
        StudentDTO result = obtenerDiplomaController.analyzeScores(studentId);

        // Assert
        Assertions.assertEquals(studentDTO.getId(), result.getId());
    }

}
