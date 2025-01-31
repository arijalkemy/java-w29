package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentDAO studentDAO;

    @Test
    @DisplayName("Analyze score successfully")
    void analyzeScoreSuccessfully() throws Exception {
        Long studentId = 1L;
        SubjectDTO math = new SubjectDTO("Matemáticas", 10.0);
        SubjectDTO history = new SubjectDTO("Historia", 9.0);

        StudentDTO student = StudentDTO.builder()
                .id(studentId)
                .studentName("Juan")
                .subjects(List.of(math, history))
                .build();

        given(studentDAO.findById(studentId)).willReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", studentId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.averageScore").value(9.5));
    }

    @Test
    @DisplayName("Student not found")
    void analyzeScoreStudentNotFound() throws Exception {
        Long studentId = 1L;

        given(studentDAO.findById(studentId)).willThrow(StudentNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", studentId))
                .andExpect(status().isNotFound());
    }
}
