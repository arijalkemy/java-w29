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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @Test
    void analyzeScoresTest() {
        //Arrange
        Long id = 1L;
        StudentDTO studentDTO = new StudentDTO(1L, "Carolina", "sdfasdfsadf", 9.0,
                List.of(
                        new SubjectDTO(
                                "Algo", 9.0
                        ),
                        new SubjectDTO(
                                "Dfgdf", 8.0
                        )
                ));
        when(service.analyzeScores(id)).thenReturn(studentDTO);

        //Act
        StudentDTO result = controller.analyzeScores(id);

        //Assert
        assertEquals(result, studentDTO);
    }
}
