package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentDAO dao;

    @BeforeEach
    public void beforeEach(){
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematicas", 1.0),
                new SubjectDTO("Fisica", 2.0),
                new SubjectDTO("Quimica", 6.0)
        );
        // StudentDTO student = new StudentDTO(1L, "Daniel", "El alumno Daniel ha obtenido un promedio de 3,00. Puedes mejorar.", 3.0, subjects);
        StudentDTO student = new StudentDTO(1L, "Daniel", null, null, subjects);

        Mockito.when(dao.findById(1L)).thenReturn(student);
        Mockito.when(dao.findById(not(eq(1L)))).thenThrow(new StudentNotFoundException(2L));
    }

    @Test
    public void givenValidUserId_WhenUserAnalyzesScores_ThenHeGetsCorrectData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Daniel"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.averageScore").value(3.0))
                .andExpect(jsonPath("$.message").value("El alumno Daniel ha obtenido un promedio de 3,00. Puedes mejorar."));
    }

    @Test
    public void givenInvalidUserId_WhenUserAnalyzesScores_ThenNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value("El alumno con Id 2 no se encuetra registrado."));
    }
}
