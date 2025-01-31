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

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    @DisplayName("Happy path Analyze Scores Puedes mejorar")
    void analyzeScoresPuedesMejorarTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,
                "Pepe","El alumno Pepe ha obtenido un promedio de 7.8. Puedes mejorar",
                7.8,subjetc);

        when(studentDAO.findById(1L)).thenReturn(student);

        var actual = service.analyzeScores(1L);

        assertEquals(student, actual);
    }

    @Test
    @DisplayName("Happy path Analyze Scores Felicitaciones")
    void analyzeScoresFelicitacionesTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",10.0));
        StudentDTO student = new StudentDTO(1L,
                "Pepe","El alumno Pepe ha obtenido un promedio de 10. Felicitaciones!",
                10.0,subjetc);

        when(studentDAO.findById(1L)).thenReturn(student);

        var actual = service.analyzeScores(1L);

        assertEquals(student, actual);
    }

    @Test
    @DisplayName("Not found analyze Scores")
    void analyzeScoresNotFoundTest(){

        when(studentDAO.findById(1L)).thenThrow(new StudentNotFoundException(1L));

        assertThrows(StudentNotFoundException.class, () -> service.analyzeScores(1L));
    }
}
