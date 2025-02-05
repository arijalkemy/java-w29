package com.meli.obtenerdiploma.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("CU1 - Analyze score finding student")
    void analyzeScoresOkTest() throws Exception {
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    @DisplayName("CU1 - Analyze score student not found")
    void analyzeScoresTestNotFound() throws Exception {
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 3L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 3 no se encuetra registrado."))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }
}