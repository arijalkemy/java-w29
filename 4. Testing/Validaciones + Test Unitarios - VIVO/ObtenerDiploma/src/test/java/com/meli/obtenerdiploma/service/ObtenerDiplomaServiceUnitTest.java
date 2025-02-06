package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceUnitTest {

    @Mock
    private StudentDAO studentDAO;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Low greeting message test")
    public void lowGreetingMessage() {
        // Arrange
        Double expectedAverage = 5D;
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Pepe",
                "Mensaje",
                null,
                List.of(new SubjectDTO(
                        "CS50",
                        expectedAverage
                ))
        );
        String expectedMessage = String.format("El alumno %s ha obtenido un promedio de %.0f. Puedes mejorar.", studentDTO.getStudentName(), expectedAverage);
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        // Assert
        assertEquals(expectedAverage, result.getAverageScore());
        assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    @DisplayName("High greeting message test")
    public void highGreetingMessage() {
        // Arrange
        Double expectedAverage = 10D;
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Pepe",
                "Mensaje",
                null,
                List.of(new SubjectDTO(
                        "CS50",
                        expectedAverage
                ))
        );
        String expectedMessage = String.format("El alumno %s ha obtenido un promedio de %.0f. Felicitaciones!", studentDTO.getStudentName(), expectedAverage);
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        // Assert
        assertEquals(expectedAverage, result.getAverageScore());
        assertEquals(expectedMessage, result.getMessage());
    }

}
