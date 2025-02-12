package com.meli.obtenerdiploma.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void obtenerDiplomaTestOk() throws Exception{

        this.mockMvc.perform(get("/analyzeScores/{studentId}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar."));

    }

    @Test
    public void obtenerDiplomaTestNoOk() throws Exception {
        this.mockMvc.perform(get("/analyzeScores/{studentId}",7))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
