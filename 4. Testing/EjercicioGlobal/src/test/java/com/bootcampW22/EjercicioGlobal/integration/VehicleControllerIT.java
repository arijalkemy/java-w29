package com.bootcampW22.EjercicioGlobal.integration;

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

    @Test
    void testGetVehiclesByBrandBetweenYears_Found()throws Exception {
        String brand = "Buick";
        int yearStart = 2004;
        int yearEnd = 2006;

        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}", brand,yearStart, yearEnd)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").isNotEmpty())
                .andExpect(jsonPath("$[0].brand").value(brand));
    }
    @Test
    void testGetVehiclesByBrandBetweenYears_Not_Found() throws Exception {
        String brand = "Buick";
        int yearStart = 2006;
        int yearEnd = 2007;

        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}", brand,yearStart, yearEnd)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    void testAverageSpeedByBrand_found() throws Exception {
        String brand = "Buick";

        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", brand)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").isNotEmpty())
                .andExpect(jsonPath("$.average_speed").value("240.0"));

    }
    @Test
    void testAverageSpeedByBrand_Notfound() throws Exception {
        String brand = "Buickk";

        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", brand)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    void testAverageCapacityByBrand_found() throws Exception {
        String brand = "Buick";

        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}", brand)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").isNotEmpty())
                .andExpect(jsonPath("$.average_capacity").value("6.0"));

    }
    @Test
    void testAverageCapacityByBrand_Notfound() throws Exception {
        String brand = "Buickk";

        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}", brand)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    void testGetVehiclesByRangeOfWeight_Found() throws Exception {
        double minWeight = 200.0;
        double maxWeight = 300.0;

        mockMvc.perform(get("/vehicles/weight")
                        .param("min", String.valueOf(minWeight))
                        .param("max", String.valueOf(maxWeight))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }
    @Test
    void testGetVehiclesByRangeOfWeight_NotFound() throws Exception {
        double minWeight = 2000.0;
        double maxWeight = 3000.0;

        mockMvc.perform(get("/vehicles/weight")
                        .param("min", String.valueOf(minWeight))
                        .param("max", String.valueOf(maxWeight))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
