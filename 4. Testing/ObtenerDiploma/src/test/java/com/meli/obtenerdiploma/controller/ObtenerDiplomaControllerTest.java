package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void givenValidStudentId_whenAnalyzeScores_thenReturnStudentDTO() {
        Long studentId = 1L;
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematicas", 8.5),
                new SubjectDTO("Fisica", 7.0)
        );
        StudentDTO student = new StudentDTO(1L, "Andres", null, null, subjects);
        student.setAverageScore(9.0);
        student.setMessage("test message");

        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(student);

        StudentDTO resultStudent = obtenerDiplomaController.analyzeScores(studentId);

        assertEquals(student, resultStudent);
        verify(obtenerDiplomaService, times(1)).analyzeScores(studentId);

    }
}
