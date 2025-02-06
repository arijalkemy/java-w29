package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // agregamos la clase

public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;
    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    void analyzeScoresOkTest(){
        //arrenge
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Juan", "hola", 9.9, new ArrayList<>());
        when(controller.analyzeScores(studentId)).thenReturn(student);
        //act
        StudentDTO result = service.analyzeScores(studentId);
        //Assert
        assertEquals(student,result);
    }

}
