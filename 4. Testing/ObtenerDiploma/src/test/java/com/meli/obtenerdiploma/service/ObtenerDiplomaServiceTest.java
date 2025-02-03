package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
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
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScores() {
        // Arrange
        Long studentId = 1L;
        StudentDTO studentDto = new StudentDTO(
                studentId,
                "Pedro",
                null,
                null,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matematicas", 9.5),
                        new SubjectDTO("Literatura", 8.8)
                )));

        // Act
        when(studentDAO.findById(studentId)).thenReturn(studentDto);
        StudentDTO expectedStudent = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        assertEquals(expectedStudent, studentDto);
        assertEquals(expectedStudent.getAverageScore(), studentDto.getAverageScore());
        assertEquals(expectedStudent.getMessage(), studentDto.getMessage());
    }

}