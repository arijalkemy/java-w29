package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest(properties = "spring.profiles.active=test")
class VehicleControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetVehiclesByColorAndYear_Found() throws Exception {
        String color = "Green";
        int year = 2005;

        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, year)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").isNotEmpty())
                .andExpect(jsonPath("$[0].color").value(color))
                .andExpect(jsonPath("$[0].year").value(year));
    }

    @Test
    void testGetVehiclesByColorAndYear_NotFound() throws Exception {
        String color = "ViolentPink";
        int year = 2050;

        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, year)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos con esos criterios."));
    }
}
