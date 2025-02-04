package com.mercadolibre.calculadorametroscuadrados.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.HouseFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIT {

    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void givenValidHouse_whenCalculate_thenReturnCorrectCalculatedHouseReponseDTO() throws Exception {
        HouseDTO house = HouseFactory.buildHouse();
        RoomDTO biggestRoom = HouseFactory.buildBigRoom();
        mockMvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(2600))
                .andExpect(jsonPath("$.price").value(2600*800))
                .andExpect(jsonPath("$.biggest.name").value(biggestRoom.getName()))
                .andExpect(jsonPath("$.biggest.width").value(biggestRoom.getWidth()))
                .andExpect(jsonPath("$.biggest.length").value(biggestRoom.getLength()));
    }

    @Test
    void givenHouseWithNoRooms_whenCalculate_thenReturnCorrectSquareFeet() throws Exception {
        HouseDTO house = HouseFactory.buildHouseWithNoRooms();
        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(0));
    }

    @Test
    void givenHouseWithNoRooms_whenCalculate_thenReturnCorrectPrice() throws Exception {
        HouseDTO house = HouseFactory.buildHouseWithNoRooms();
        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(0));
    }

    @Test
    void givenHouseWithNoRooms_whenCalculate_thenReturnNullBiggest() throws Exception {
        HouseDTO house = HouseFactory.buildHouseWithNoRooms();
        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.biggest").value(nullValue()));
    }
}
