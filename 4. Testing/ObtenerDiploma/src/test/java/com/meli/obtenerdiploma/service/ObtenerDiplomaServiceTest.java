package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    //Caso vacío
    @Test
    void testAnalyzeScoresWithNullCase() {
       //arrange
        when(studentDAO.findById(anyLong())).thenReturn(null);
        //action and assert
        assertThrows(IllegalArgumentException.class, () -> obtenerDiplomaService.analyzeScores(1L));
    }


    //Datos de salida identicos a los de entrada
    void testAnalyzeWithEqualsInputAndOutput(){
        //arrange
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Math", 10D),
                new SubjectDTO("Science", 10D),
                new SubjectDTO("History", 10D)
        );
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Juan Perez");
        student.setSubjects(subjects);

        //action
        when(studentDAO.findById(1L)).thenReturn(student);

        //assert
        assertEquals(student.getStudentName(), obtenerDiplomaService.analyzeScores(1L).getStudentName());
        assertEquals(student.getSubjects(), obtenerDiplomaService.analyzeScores(1L).getSubjects());

    }

    //Calculo del promedio
    void testAnalyzeScoreWithAverage(){
        //arrange
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Math", 10D),
                new SubjectDTO("Science", 10D),
                new SubjectDTO("History", 10D)
        );
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Juan Perez");
        student.setSubjects(subjects);
        // action
        when(studentDAO.findById(1L)).thenReturn(student);
        // assert
        assertEquals(10D, obtenerDiplomaService.analyzeScores(1L).getAverageScore());
    }



    //Leyenda del diploma
    @Test
    void testAnalyzeScoreGreaterThanNine() {
        //arrange
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Math", 10D),
                new SubjectDTO("Science", 10D),
                new SubjectDTO("History", 10D)
        );
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Juan Perez");
        student.setSubjects(subjects);

        //action
        when(studentDAO.findById(1L)).thenReturn(student);

        //assert
        assertEquals("El alumno Juan Perez ha obtenido un promedio de 10. Felicitaciones!", obtenerDiplomaService.analyzeScores(1L).getMessage());
    }

    @Test
    void testAnalyzeScoreLessThanNine() {
        //arrange
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Math", 8D),
                new SubjectDTO("Science", 8D),
                new SubjectDTO("History", 8D)
        );
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Juan Perez");
        student.setSubjects(subjects);

        //action
        when(studentDAO.findById(1L)).thenReturn(student);

        //assert
        assertEquals("El alumno Juan Perez ha obtenido un promedio de 8. Puedes mejorar.", obtenerDiplomaService.analyzeScores(1L).getMessage());


    }
}








