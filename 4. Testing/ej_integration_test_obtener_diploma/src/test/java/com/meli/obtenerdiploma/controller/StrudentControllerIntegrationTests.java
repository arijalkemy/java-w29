package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StrudentControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentDAO dao;

    private StudentDTO student;
    private StudentDTO badStudent;

    @BeforeEach
    public void beforeEach(){
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematicas", 1.0),
                new SubjectDTO("Fisica", 2.0),
                new SubjectDTO("Quimica", 6.0)
        );
        // StudentDTO student = new StudentDTO(1L, "Daniel", "El alumno Daniel ha obtenido un promedio de 3,00. Puedes mejorar.", 3.0, subjects);
        student = new StudentDTO(1L, "Daniel", null, null, subjects);
        badStudent = new StudentDTO(1L, "daniel", null, null, subjects);

        Mockito.doNothing().when(dao).save(student);
        // Mockito.when(dao.findById(not(eq(1L)))).thenThrow(new StudentNotFoundException(2L));
    }

    @Test
    public void givenValidStudent_WhenUserRegisters_ThenHeIsSaved() throws Exception {
        String json = new ObjectMapper().writeValueAsString(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void givenInvalidStudent_WhenUserRegisters_ThenBadRequest() throws Exception {
        String json = new ObjectMapper().writeValueAsString(badStudent);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }

}
