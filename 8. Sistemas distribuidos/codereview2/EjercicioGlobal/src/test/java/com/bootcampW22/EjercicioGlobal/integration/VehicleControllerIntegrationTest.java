package com.bootcampW22.EjercicioGlobal.integration;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerIntegrationTest {

    @Autowired
    public MockMvc mockMvc;

    @Test
    public void getVehiclesByColorAndYear_returnSucessResponseEntity() throws Exception {
        String color = "Puce";
        int year = 1994;
        MvcResult result = mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, year))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRes = result.getResponse().getContentAsString();

        List<VehicleDto> resVehicleDTOList = objectMapper.readValue(jsonRes, new TypeReference<>(){});

        resVehicleDTOList.forEach(vehicleDto -> {
            assertEquals(color, vehicleDto.getColor());
            assertEquals(year, vehicleDto.getYear());
        });
    }

    @Test
    public void getVehiclesByColorAndYear_returnNotFoundException() throws Exception {
        String color = "Puce";
        int year = 2025;
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, year))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos con esos criterios."));
    }
}
