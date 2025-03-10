package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.Datos;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    /* @Override
    public StudentDTO analyzeScores(Long studentId) {
        StudentDTO stu = studentDAO.findById(studentId);
        stu.setAverageScore(calculateAverage(stu.getSubjects()));
        stu.setMessage(getGreetingMessage(stu.getStudentName(), stu.getAverageScore()));
        return stu;
    }


    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }*/

    @Test
    @DisplayName("AnalyzeScores AverageScore less than 9")
    void testAnalyzeScoresless9() {
        //Arrange
        StudentDTO expected= new StudentDTO(1L, "Juan","El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.",8.00, List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("History", 8.0)));
        when(studentDAO.findById(1L)).thenReturn(Datos.unEstudiante());
        Long id=expected.getId();
        Double expectedDouble=8.00;
        String expectedMessage="El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.";
        //ACT
        StudentDTO actual= obtenerDiplomaService.analyzeScores(id);
        //Assert
        assertEquals(expected,actual);
        assertEquals(expectedDouble,actual.getAverageScore());
        assertEquals(expectedMessage,actual.getMessage());
    }

    @Test
    @DisplayName("AnalyzeScores AverageScore more than 9")
    void testAnalyzeScoresplus9() {
        //Arrange
        StudentDTO expected= new StudentDTO(1L, "Juan","El alumno Juan ha obtenido un promedio de 10. Felicitaciones!",10.00, List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("History", 10.0)));
        Long id=expected.getId();
        when(studentDAO.findById(id)).thenReturn(Datos.unEstudiante10());
        Double expectedDouble=10.00;
        String expectedMessage="El alumno Juan ha obtenido un promedio de 10. Felicitaciones!";
        //ACT
        StudentDTO actual= obtenerDiplomaService.analyzeScores(1L);
        //Assert
        assertEquals(expected,actual);
        assertEquals(expectedDouble,actual.getAverageScore());
        assertEquals(expectedMessage,actual.getMessage());
    }
    @Test
    @DisplayName("AnalyzeScores AverageScore more than 9")
    void testAnalyzeScoresSadPath() {
        //Arrange
        when(studentDAO.findById(anyLong())).thenThrow(StudentNotFoundException.class);
        //act & assert
        assertThrows(StudentNotFoundException.class,()-> obtenerDiplomaService.analyzeScores(anyLong()));
        verify(studentDAO).findById(anyLong());
    }
}