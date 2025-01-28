package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @ArgumentsSource(StudentArgumentsSource.class)
    void testAnalyzeScores(Long studentId, String studentName, List<SubjectDTO> subjects, double expectedAverage, String expectedMessage) {
        StudentDTO student = StudentDTO.builder()
                .id(studentId)
                .studentName(studentName)
                .subjects(subjects)
                .build();
        when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals(expectedAverage, result.getAverageScore(), 0.01, "El promedio calculado no es el esperado.");
    }

    static class StudentArgumentsSource implements org.junit.jupiter.params.provider.ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(org.junit.jupiter.api.extension.ExtensionContext context) {
            SubjectDTO math = new SubjectDTO("Matemáticas", 10.0);
            SubjectDTO history = new SubjectDTO("Historia", 9.5);
            SubjectDTO biology = new SubjectDTO("Biología", 8.0);
            SubjectDTO physics = new SubjectDTO("Física", 6.5);
            SubjectDTO chemistry = new SubjectDTO("Química", 7.0);
            SubjectDTO english = new SubjectDTO("Inglés", 10.0);

            return Stream.of(
                    Arguments.of(1L, "Juan", List.of(math, history), 9.75, null),
                    Arguments.of(2L, "Ana", List.of(biology, physics, chemistry), 7.17, null),
                    Arguments.of(3L, "Carlos", List.of(english), 10.0, null)
            );
        }
    }

}