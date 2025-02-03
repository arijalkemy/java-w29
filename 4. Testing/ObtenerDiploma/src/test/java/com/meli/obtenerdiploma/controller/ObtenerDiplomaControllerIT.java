package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.StudentTestFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IStudentDAO studentDAO;

    @Test
    void givenExistingStudent_whenAnalyzeScores_thenReturnStudentDTO() throws Exception {
        StudentDTO student = StudentTestFactory.buildStudentWithSubjects(1L);
        studentDAO.save(student);

        mockMvc.perform(get("/analyzeScores/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("John"))
                .andExpect(jsonPath("$.averageScore").value(6.5))
                .andExpect(jsonPath("$.message").value("El alumno John ha obtenido un promedio de 6.5. Puedes mejorar."));

    }

    @Test
    void givenNonExistingStudent_whenAnalyzeScores_thenThrowException() throws Exception {
        mockMvc.perform(get("/analyzeScores/99"))
                .andExpect(status().isNotFound());

    }
}
