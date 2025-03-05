package com.bootcampW22.EjercicioGlobal.integration;

import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("EP01 - Happy Path: getVehiclesByColorAndYear ok")
    public void getVehiclesByColorAndYear() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/color/{color}/year/{year}", "test", 1111))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(501L))
                .andExpect(jsonPath("$[*].id", containsInAnyOrder(501)));
    }

    @Test
    @DisplayName("EP01 - getVehiclesByColorAndYear throws NotFoundException")
    public void getVehiclesByColorAndYearThrowsNotFoundException() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/color/{color}/year/{year}", "hola", 3241))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos con esos criterios."));
    }

    @Test
    @DisplayName("EP02: Happy Path: getVehiclesByColorAndRangeOfYear ok")
    public void getVehiclesByColorAndRangeOfYear() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/brand/{brand}/between/{start_year}/{end_year}", "test", 1110, 1112))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(501));
    }

    @Test
    @DisplayName("EP02: Happy Path: getVehiclesByColorAndRangeOfYear Throws NotFoundException")
    public void getVehiclesByColorAndRangeOfYearThrowsNotFoundException() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/brand/{brand}/between/{start_year}/{end_year}", "asdf", 2323, 2323))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos con esos criterios."));
    }



}
