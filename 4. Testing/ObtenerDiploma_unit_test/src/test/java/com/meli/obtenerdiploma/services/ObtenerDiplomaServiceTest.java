package com.meli.obtenerdiploma.services;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;


    @Test
    @DisplayName("Analyze Scores DTO OK")
    public void analayzeScoresTestOK(){
        //arrange
        Long studentID = 1L;
        StudentDTO studentDTOExpected = new StudentDTO(
                studentID,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333,
                List.of(new SubjectDTO("Matemática",9.0),new SubjectDTO("Física",7.0), new SubjectDTO("Química",6.0))
        );
        StudentDTO studentDTODaoResponse = new StudentDTO(
                studentID,
                "Juan",
                null,
                null,
                List.of(new SubjectDTO("Matemática",9.0),new SubjectDTO("Física",7.0), new SubjectDTO("Química",6.0))
        );
        when(studentDAO.findById(studentID)).thenReturn(studentDTODaoResponse);
        //act
        StudentDTO studentDTOActual = obtenerDiplomaService.analyzeScores(studentID);
        //assert
        Assertions.assertEquals(studentDTOExpected,studentDTOActual);
    }

    @Test
    @DisplayName("Analyze Scores Average No OK")
    public void analayzeScoresAverageTestNoOK() {
        //arrange
        Long studentID = 1L;
        StudentDTO studentDTOExpected = new StudentDTO(
                studentID,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333,
                List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0))
        );
        StudentDTO studentDTODaoResponse = new StudentDTO(
                studentID,
                "Juan",
                null,
                null,
                List.of(new SubjectDTO("Matemática", 5.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0))
        );
        when(studentDAO.findById(studentID)).thenReturn(studentDTODaoResponse);
        //act
        StudentDTO studentDTOActual = obtenerDiplomaService.analyzeScores(studentID);
        //assert
        Assertions.assertTrue(!Objects.equals(studentDTOExpected.getAverageScore(), studentDTOActual.getAverageScore()));

    }




}
