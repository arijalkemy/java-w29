package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("analyzeScores happy path")
    public void analyzeScores() {
        //Arrange
        StudentDTO studentMock = new StudentDTO(30L,"Mario", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
                ));
        when(studentDAO.findById(30L)).thenReturn(studentMock);
        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(30L);
        //Asserts
        assertEquals(8.0,result.getAverageScore());
    }

    @Test
    @DisplayName("getGreetingMessageMoreNine happy path")
    public void getGreetingMessageMoreNine(){
        //Arrange
        StudentDTO studentMock = new StudentDTO(30L,"Mario", "",0.0, List.of(
                new SubjectDTO("Lengua", 10.0),
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 9.0)
        ));
        when(studentDAO.findById(30L)).thenReturn(studentMock);
        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(30L);
        //Asserts
        assertEquals("El alumno Mario ha obtenido un promedio de 9,33. Felicitaciones!",result.getMessage());

    }
    @Test
    @DisplayName("getGreetingMessageMinorNine happy path")
    public void getGreetingMessageMinorNine(){
        //Arrange
        StudentDTO studentMock = new StudentDTO(30L,"Mario", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        ));
        when(studentDAO.findById(30L)).thenReturn(studentMock);
        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(30L);
        //Asserts
        assertEquals("El alumno Mario ha obtenido un promedio de 8. Puedes mejorar.", result.getMessage());

    }
}
