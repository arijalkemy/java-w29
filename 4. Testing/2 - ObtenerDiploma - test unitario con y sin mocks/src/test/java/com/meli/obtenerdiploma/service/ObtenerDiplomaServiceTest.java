package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    /*
    * Casos nulos, vacíos, inválidos.
    * Datos de Salida idénticos a datos de Entrada.
    * Cálculo del Promedio.
    * Leyenda del Diploma.
    * Mensaje de Diploma con Honores.
    * */
    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Happy path - user id exists + score > 9")
    void analyzeScoresTest_whenUserIdExistsAndAproved_thenReturnAStudentDto(){
        Double expectedAverage = 9.75;
        Long userId = 1L;
        StudentDTO studentDTO = new StudentDTO(
                userId,
                "Eliana",
                null,
                null,
                List.of(
                        new SubjectDTO("Science", 10D),
                        new SubjectDTO("Science II", 9.5D)
                )
        );
        String expectedMessage = String.format("El alumno %s ha obtenido un promedio de %.2f. Felicitaciones!",
                studentDTO.getStudentName(),
                expectedAverage);

        when(iStudentDAO.findById(userId)).thenReturn(studentDTO);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        // Assert
        assertEquals(expectedAverage, result.getAverageScore());
        assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    @DisplayName("Happy path - user id exists + score < 9")
    void analyzeScoresTest_whenUserIdExistsAndIsntAproved_thenReturnAStudentDto(){
        Double expectedAverage = 8D;
        Long userId = 1L;
        StudentDTO studentDTO = new StudentDTO(
                userId,
                "Eliana",
                null,
                null,
                List.of(
                        new SubjectDTO("Science", 10D),
                        new SubjectDTO("Science II", 6D)
                )
        );
        String expectedMessage = String.format("El alumno %s ha obtenido un promedio de %.0f. Puedes mejorar.", studentDTO.getStudentName(), expectedAverage);
        when(iStudentDAO.findById(userId)).thenReturn(studentDTO);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        // Assert
        assertEquals(expectedAverage, result.getAverageScore());
        assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    @DisplayName("Error path - user id doesn't exist")
    void analyzeScoresTest_whenUserIdDoesntExist_thenThrowException() {
        // Arrange
        Long userId = 999L;
        when(iStudentDAO.findById(userId)).thenThrow(new StudentNotFoundException(userId));

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(userId));
    }


    @Test
    @DisplayName("Invalid input - null student object")
    void analyzeScoresTest_whenStudentIsNull_thenThrowException() {
        // Arrange
        when(iStudentDAO.findById(null)).thenThrow(new IllegalArgumentException("ID cannot be null"));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> obtenerDiplomaService.analyzeScores(null));
    }

    @Test
    @DisplayName("Invalid input - Negative student ID")
    void analyzeScoresTest_whenStudentIdIsNegative_thenThrowException() {
        // Arrange
        Long invalidUserId = -1L;
        when(iStudentDAO.findById(invalidUserId)).thenThrow(new IllegalArgumentException("Invalid student ID"));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> obtenerDiplomaService.analyzeScores(invalidUserId));
    }

}
