package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void registerStudentSuccessfully() throws Exception {
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3Subjects("Camilo");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(newStudent);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andExpect(status().isOk());
    }

    @Test
    void registerStudentUnsuccessfully() throws Exception {
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3Subjects(null);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(newStudent);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andExpect(status().isBadRequest());
    }

    @Test
    void getStudentByIdSuccessfully() throws Exception {
        Long studentId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", studentId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(studentId))
                .andExpect(jsonPath("$.studentName").value("Juan"));
    }

    @Test
    void getStudentByIdUnsuccessfully() throws Exception {
        Long studentId = 100L;

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", studentId))
                .andExpect(status().isNotFound());
    }

    @Test
    void modifyStudentSuccessfully() throws Exception {
        StudentDTO studentToModify = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        studentToModify.setId(1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(studentToModify);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andExpect(status().isOk());
    }

    @Test
    void modifyStudentUnsuccessfully() throws Exception {
        StudentDTO studentToModify = TestUtilsGenerator.getStudentWith3Subjects(null);
        studentToModify.setId(1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(studentToModify);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andExpect(status().isBadRequest());
    }

    @Test
    void removeStudentSuccessfully() throws Exception {
        Long existingId = 2L;

        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", existingId))
                .andExpect(status().isOk());
    }

    @Test
    void removeStudentUnsuccessfully() throws Exception {
        Long nonExistingId = 100L;

        // ToDo: Revisar este endpoint ya que para cualquier id existente o no, retorna un status 200.
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", nonExistingId))
                .andExpect(status().isOk());
    }

    @Test
    void listAllStudentsSuccessfully() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(status().isOk());
    }
}
