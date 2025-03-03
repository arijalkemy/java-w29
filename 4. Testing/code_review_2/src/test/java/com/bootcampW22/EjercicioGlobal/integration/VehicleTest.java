package com.bootcampW22.EjercicioGlobal.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("EP01 - Happy Path: Search Vehicle By Year and Color")
    public void getVehiclesByColorAndYear() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/color/{color}/year/{year}", "Maroon", 2002))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }


}
