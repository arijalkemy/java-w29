package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresTest(){

        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática" ,8.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Lengua" ,6.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Física" ,4.0);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectDTO1);
        listSubjects.add(subjectDTO2);
        listSubjects.add(subjectDTO3);
        StudentDTO studentDTOExpect = new StudentDTO(
                1L,
                "Camilo",
                "El alumno Camilo ha obtenido un promedio de 6. Puedes mejorar.",
                6.0,
                listSubjects);

        StudentDTO studentDTO = new StudentDTO(1L,"Camilo", "",0.0,listSubjects);
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        StudentDTO response = obtenerDiplomaService.analyzeScores(studentDTO.getId());
        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        assertEquals(studentDTOExpect, response);
    }

    @Test
    public void analyzeScoresWithAverageGreaterThanNineTest(){

        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática" ,9.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Lengua" ,10.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Física" ,8.5);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectDTO1);
        listSubjects.add(subjectDTO2);
        listSubjects.add(subjectDTO3);
        StudentDTO studentDTOExpect = new StudentDTO(
                1L,
                "Camilo",
                "El alumno Camilo ha obtenido un promedio de 9,17. Felicitaciones!",
                9.166666666666666,
                listSubjects);

        StudentDTO studentDTO = new StudentDTO(1L,"Camilo", "",0.0,listSubjects);
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        StudentDTO response = obtenerDiplomaService.analyzeScores(studentDTO.getId());
        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        assertEquals(studentDTOExpect, response);
    }




}
