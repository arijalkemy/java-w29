package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analyze scores with non-existing studentId")
    void testAnalyzeScoreWithNonExistingId() {
        // Arrange
        Long nonExistingId = 5L;

        when(studentDAO.findById(nonExistingId)).thenThrow(new StudentNotFoundException(nonExistingId));

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(nonExistingId));

        verify(studentDAO, atLeastOnce()).findById(nonExistingId);
    }

    @ParameterizedTest
    @MethodSource("analyzeScoresInputs")
    @DisplayName("Analyze Scores with parameters")
    void testAnalyzeScores(Long studentId, String studentName, List<SubjectDTO> subjects, double expectedAverage) {
        // Arrange
        StudentDTO student = StudentDTO.builder().id(studentId).studentName(studentName).subjects(subjects).build();

        // Act
        when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        assertEquals(expectedAverage, result.getAverageScore(), 0.01, "El promedio calculado no es el esperado.");

        assertEquals(studentName, result.getStudentName(), "El nombre no es el esperado.");

        assertEquals(subjects.size(), result.getSubjects().size(), "Las materias no coinciden.");
    }

    static Stream<Arguments> analyzeScoresInputs() {
        SubjectDTO math = new SubjectDTO("Matemáticas", 10.0);
        SubjectDTO history = new SubjectDTO("Historia", 9.5);
        SubjectDTO biology = new SubjectDTO("Biología", 8.0);
        SubjectDTO physics = new SubjectDTO("Física", 6.5);
        SubjectDTO chemistry = new SubjectDTO("Química", 7.0);
        SubjectDTO english = new SubjectDTO("Inglés", 10.0);

        return Stream.of(Arguments.of(1L, "Juan", List.of(math, history), 9.75),
                Arguments.of(2L, "Ana", List.of(biology, physics, chemistry), 7.17),
                Arguments.of(3L, "Carlos", List.of(english), 10.0));
    }
}
