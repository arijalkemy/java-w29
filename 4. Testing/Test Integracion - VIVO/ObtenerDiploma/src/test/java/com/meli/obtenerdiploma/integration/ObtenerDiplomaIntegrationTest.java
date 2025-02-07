package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("should register a student and return a 200 code response")
    public void registerStudentAndReturn200Code() throws Exception {

        // Arrange
        StudentDTO request = new StudentDTO(
                null,
                "Pepe",
                null,
                null,
                List.of(
                        new SubjectDTO(
                        "CS50",
                        10D
                )));

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(request);

        // Act and Assert
        mockMvc
                .perform(
                        post("/student/registerStudent")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("should not register a student and return a 403 response")
    public void registerStudentAndReturn403() throws Exception {
        // Arrange
        StudentDTO request = new StudentDTO();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(request);

        // Act and Assert
        mockMvc
                .perform(
                        post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("should retrieve the list of all students and a 200 response")
    public void retrieveAllStudentsAndReturn200Code() throws Exception {
        // Act and Assert
        mockMvc
                .perform(
                        get("/student/listStudents")
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should retrieve a student by id and return a 200 response")
    public void retrieveStudentByIdAndReturn200Code() throws Exception {
        // Arrange
        StudentDTO request = new StudentDTO(
                null,
                "Pepe",
                null,
                null,
                List.of(
                        new SubjectDTO(
                                "CS50",
                                10D
                        )));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(request);

        mockMvc
                .perform(
                        post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult listResult = mockMvc
                .perform(get("/student/listStudents").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper om = new ObjectMapper();

        List<StudentDTO> students = om.readValue(listResult.getResponse().getContentAsString(), new TypeReference<>() {
        });

        Long generatedId = students.get(students.size() - 1).getId();


        // Act and Assert
        mockMvc
                .perform(
                        get("/student/getStudent/{id}", generatedId)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(generatedId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(request.getStudentName()));

    }

    @Test
    @DisplayName("should not retrieve a student with a bad id and return a 404 response")
    public void retrieveStudentByIdAndReturn404() throws Exception {
        // Arrange
        Long randomId = 99999L;

        // Act and Assert
        mockMvc
                .perform(
                        get("/student/getStudent/{id}", randomId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }



}
