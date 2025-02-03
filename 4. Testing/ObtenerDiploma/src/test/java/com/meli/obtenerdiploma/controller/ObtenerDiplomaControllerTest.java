package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScores(){
        // Arrange
        Long studentId = 1L;
        StudentDTO expectedStudentDTO = new StudentDTO(
                studentId,
                "Pedro",
                null,
                null,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matematicas", 9.5),
                        new SubjectDTO("Literatura", 8.8)
                )));

        // Act
        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expectedStudentDTO);
        StudentDTO studentDTO = obtenerDiplomaController.analyzeScores(studentId);

        // Assert
        assertEquals(expectedStudentDTO, studentDTO);
    }

}