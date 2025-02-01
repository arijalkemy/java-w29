package com.meli.obtenerdiploma.controllers;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;


    @Test
    @DisplayName("Analyze Scores Controller Test Ok")
    public void analyzeScores(){
        //Arrange
        Long studentIdParam = 1L;
        StudentDTO studentDTOResponse = TestUtilsGenerator.getStudentWithId(studentIdParam);
        StudentDTO studentDTOExpected = TestUtilsGenerator.getStudentWithId(studentIdParam);
        when(iObtenerDiplomaService.analyzeScores(studentIdParam)).thenReturn(studentDTOResponse);
        //Act
        StudentDTO studentDTOActual =  obtenerDiplomaController.analyzeScores(studentIdParam);
        //Assert
        Assertions.assertEquals(studentDTOExpected,studentDTOActual);
    }
}
