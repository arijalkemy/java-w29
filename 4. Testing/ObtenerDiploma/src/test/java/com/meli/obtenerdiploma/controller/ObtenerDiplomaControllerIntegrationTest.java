package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        new StudentDAO().save(TestUtilsGenerator.getStudentWith3Subjects("Andres"));
    }

    @Test
    public void analyzeScoresOk() throws Exception {
        MvcResult res = this.mockMvc.perform(
                        get("/analyzeScores/{studentId}", 1))
                .andDo(print()).andReturn();

        StudentDTO studentDTO = new ObjectMapper().readValue(res.getResponse().getContentAsString(), StudentDTO.class);

        Assertions.assertEquals("Andres", studentDTO.getStudentName());
        Assertions.assertEquals(1, studentDTO.getId());
        Assertions.assertEquals(200, res.getResponse().getStatus());
        Assertions.assertEquals(MediaType.APPLICATION_JSON.toString(), res.getResponse().getContentType());
        Assertions.assertNull(res.getResponse().getErrorMessage());
    }

    @Test
    public void analyzeScoresThrowExceptionMessage() throws Exception {
        mockMvc.perform(
                get("/analyzeScores/{studentId}", 9999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    }
}