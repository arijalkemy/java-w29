package com.bootcampW22.EjercicioGlobal.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class VehicleControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getVehiclesByColorAndYearFound() throws Exception {
        mockMvc.perform(get("/vehicles/color/Red/year/2021"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(2416));
    }

    @Test
    void getVehiclesByColorAndYearNotFound() throws Exception{
        mockMvc.perform(get("/vehicles/color/Purple/year/1990"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getVehiclesByBrandAndRangeOfYearFound() throws Exception {
        mockMvc.perform(get("/vehicles/brand/Renault/between/2020/2022"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(2416))
                .andExpect(jsonPath("$[0].brand").value("Renault"))
                .andExpect(jsonPath("$[0].year").value(2021));
    }

    @Test
    void getVehiclesByBrandAndRangeOfYearNotFound() throws Exception {
        mockMvc.perform(get("/vehicles/brand/Toyota/between/1800/1850"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getAverageSpeedByBrandFound() throws Exception {
        mockMvc.perform(get("/vehicles/average_speed/brand/Renault"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.average_speed").value(167));
    }

    @Test
    void getAverageSpeedByBrandNotFound() throws Exception {
        mockMvc.perform(get("/vehicles/average_speed/brand/UnknownBrand"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getAverageCapacityByBrandFound() throws Exception {
        mockMvc.perform(get("/vehicles/average_capacity/brand/Renault"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.average_capacity").value(5));
    }

    @Test
    void getAverageCapacityByBrandNotFound() throws Exception {
        mockMvc.perform(get("/vehicles/average_capacity/brand/UnknownBrand"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getVehiclesByRangeOfWeightFound() throws Exception {
        mockMvc.perform(get("/vehicles/weight?min=900&max=1100"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(2416))
                .andExpect(jsonPath("$[0].weight").value(1000.0));
    }

    @Test
    void getVehiclesByRangeOfWeightNotFound() throws Exception {
        mockMvc.perform(get("/vehicles/weight?min=5000&max=10000"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
