package com.meli.obtenerdiploma.service;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService diplomaService;

    private final Long USER_ID = 1L;
    private final String STUDENT_NAME = "Matías";
    private final String STUDENT_MESSAGE = "Mensaje descriptivo";

    /* Inmutable */
    private final List<SubjectDTO> SUBJECTS_APROVED = List.of(
            new SubjectDTO("Subject 1", 9.5),
            new SubjectDTO("Subject 2", 10.0));

    private final List<SubjectDTO> SUBJECTS_FAILED = List.of(
            new SubjectDTO("Subject 1", 2.0),
            new SubjectDTO("Subject 2", 9.0));

    @Test
    public void test_analyzeScore_failed() {
        // 1. Precondiciones
        StudentDTO expectedStudent = new StudentDTO(USER_ID, STUDENT_NAME, STUDENT_MESSAGE, 0d, SUBJECTS_FAILED);

        // Mock del comportamiento del DAO
        Mockito.when(studentDAO.findById(USER_ID)).thenReturn(expectedStudent);

        // 2. Ejercitar la clase under-test
        StudentDTO studentDto = diplomaService.analyzeScores(USER_ID);

        // 3. Validar las postcondiciones
        Double avg = 5.5;
        String message = String.format("El alumno %s ha obtenido un promedio de %.1f. Puedes mejorar.", STUDENT_NAME, avg);

        assertNotNull(studentDto);
        assertEquals(STUDENT_NAME, studentDto.getStudentName());
        assertEquals(message, studentDto.getMessage());
        assertEquals(avg, studentDto.getAverageScore());
        assertEquals(SUBJECTS_FAILED.size(), studentDto.getSubjects().size());
    }


    @Test
    public void test_analyzeScore_aproved() {
        // 1. Precondiciones
        StudentDTO expectedStudent = new StudentDTO(USER_ID, STUDENT_NAME, STUDENT_MESSAGE, 0d, SUBJECTS_APROVED);

        // Mock del comportamiento del DAO
        Mockito.when(studentDAO.findById(USER_ID)).thenReturn(expectedStudent);

        // 2. Ejercitar la clase under-test
        StudentDTO studentDto = diplomaService.analyzeScores(USER_ID);

        // 3. Validar las postcondiciones
        Double avg = 9.75;
        String message = String.format("El alumno %s ha obtenido un promedio de %.2f. Felicitaciones!", STUDENT_NAME, avg);

        assertNotNull(studentDto);
        assertEquals(STUDENT_NAME, studentDto.getStudentName());
        assertEquals(message, studentDto.getMessage());
        assertEquals(avg, studentDto.getAverageScore());
        assertEquals(SUBJECTS_APROVED.size(), studentDto.getSubjects().size());
    }




}
