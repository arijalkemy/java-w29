package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
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
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void analyzeScoresTest() {
        // Arrange
        //Parametro que recibe
        Long studentID = 1L;
        //Parametro que retorna

        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        );

        StudentDTO stu = new StudentDTO(studentID, "juan", null, null, subjects);

        // Act
        //Lo que hace es definir los parametros de "stu" y no los reales que serian "studentDAO.findById(studentID)"
        when(studentDAO.findById(studentID)).thenReturn(stu);
        StudentDTO expected = obtenerDiplomaService.analyzeScores(studentID);

        // Assert
        assertEquals(stu, expected);
        assertEquals(stu.getAverageScore(), expected.getAverageScore());
        assertEquals(stu.getMessage(), expected.getMessage());
    }


}