package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTests {

    @Autowired
    private MockMvc mocMvc;

    @MockBean
    private StudentDAO studentDAO;

    /*Esto devuelve un student DTO*/
    @Test
    @DisplayName("Analyze score successfully")
    void analyzeScoreSuccessfully() throws Exception {
        Long studentId = 1L;
        SubjectDTO bdd = new SubjectDTO("BaseDeDatos", 10.0);
        SubjectDTO tdp = new SubjectDTO("TallerDeDesarrolloDeProyectos", 8.0);

        StudentDTO student = StudentDTO.builder()
                .id(studentId)
                .studentName("Chris")
                .subjects(List.of(bdd, tdp))
                .build();

        given(studentDAO.findById(studentId)).willReturn(student);

        mocMvc.perform(get("/analyzeScores/{id}", studentId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.averageScore").value(9.0));

    }

    /*Arrojo la excepcion*/
    @Test
    @DisplayName("Student not found")
    void analyzeScoreStudentNotFound() throws Exception {
        Long studentId = 1L;

        given(studentDAO.findById(studentId)).willThrow(StudentNotFoundException.class);

        mocMvc.perform(get("/analyzeScores/{id}", studentId))
                .andExpect(status().isNotFound());
    }
}
