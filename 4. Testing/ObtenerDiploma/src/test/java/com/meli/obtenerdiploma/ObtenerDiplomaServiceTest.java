package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObtenerDiplomaServiceTest {
    private ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    public void setUp() {
        obtenerDiplomaService = new ObtenerDiplomaService();
    }

    @Test
    @DisplayName("analyzeScores Happy Ending")
    public void analyzeScoresTest() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Michell");
        studentDTO.setSubjects(Arrays.asList(
                new SubjectDTO("Matemáticas", 8.9),
                new SubjectDTO("Historia", 7.5),
                new SubjectDTO("Ciencias", 4.1)
        ));
        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentDTO);
        //assert
        assertEquals(6.84, result.getAverageScore(),0.01);
    }
}
