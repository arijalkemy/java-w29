package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void registerStudent() throws Exception{
        // Arrange
        SubjectDTO math = new SubjectDTO("Matematicas", 9.5);
        SubjectDTO literature = new SubjectDTO("Literatura", 8.8);
        SubjectDTO chemistry = new SubjectDTO("Química", 5.8);

        StudentDTO newStudent = new StudentDTO(1000L, "Agatha", null, 0.0, List.of(math, literature, chemistry));

        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(newStudent);


        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)
        ).andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void registerStudent_shouldReturnBadRequestForEmptyBody() throws Exception {
        // Arrange
        String body = "{}";

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)
        ).andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void getStudent() throws Exception{
        Long studentId = 10L;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{studentId}", studentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(studentId));
    }

    @Test
    void getStudent_shouldReturnNotFound() throws Exception{
        Long studentId = 1000L;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{studentId}", studentId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id " + studentId + " no se encuetra registrado."));
    }

    @Test
    void modifyStudent() throws Exception{
// Arrange
        SubjectDTO math = new SubjectDTO("Matematicas", 9.5);
        SubjectDTO literature = new SubjectDTO("Literatura", 8.8);
        SubjectDTO chemistry = new SubjectDTO("Química", 5.8);

        StudentDTO studentToUpdate = new StudentDTO(1L, "Juan Pérez", null, 0.0, List.of(math, literature, chemistry));

        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(studentToUpdate);


        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudent_shouldReturnBadRequestForEmptyBody() throws Exception {
        // Arrange
        String body = "{}";

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                ).andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void removeStudent() throws Exception {
        Long studentId = 1L;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void listStudents() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }
}