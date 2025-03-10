package com.bootcampW22.EjercicioGlobal.Integration;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleIntegrationTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void getVehiclesTest() throws Exception {
        mockMvc.perform(get("/vehicles"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));
    }

    @Test
    public void getVehiclesByColorAndYear() throws Exception {
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", "Green", 2005))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[*].year", everyItem(equalTo(2005))))
                .andExpect(jsonPath("$[*].color", everyItem(equalTo("Green"))))
                .andReturn();
    }

    @Test
    public void getVehiclesByColorAndRangeOfYear() throws Exception {
        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}", "Toyota", 1990, 2009))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].year", everyItem(greaterThan(1990))))
                .andExpect(jsonPath("$[*].year", everyItem(lessThan(2009))))
                .andExpect(jsonPath("$.length()").value(1))
                .andReturn();
    }

    @Test
    public void getAverageCapacityByBrand() throws Exception {
        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}", "Toyota"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[*].brand", everyItem(equalTo("Toyota"))))
                .andReturn();
    }


}
