package com.meli.obtenerdiploma.controller;

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
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void analyzeScoreSuccessfully() throws Exception {
        Long studentId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", studentId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(studentId))
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.averageScore").value(7));
    }

    @Test
    void analyzeScoreIdInvalid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", 99L))
                .andExpect(status().isNotFound());
    }
}
