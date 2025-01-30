package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class CalculateRestControllerIT {

    RoomDTO room1 = RoomDTO.builder().width(10).length(10).build();
    RoomDTO room2 = RoomDTO.builder().width(20).length(10).build();
    RoomDTO room3 = RoomDTO.builder().width(20).length(30).build();

    HouseDTO house = HouseDTO.builder()
            .rooms(List.of(room1, room2, room3))
            .build();

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Successful test")
    void testCalculateSuccessful() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(720000)) // (10*10 + 10*20 + 20*30) * 800
                .andExpect(jsonPath("$.biggest.width").value(room3.getWidth()))
                .andExpect(jsonPath("$.biggest.length").value(room3.getLength()))
                .andExpect(jsonPath("$.squareFeet").value(900)); // (10*10 + 10*20 + 20*30)
    }

    @Test
    @DisplayName("Test con casa sin habitaciones")
    void testCalculateWithNoRooms() throws Exception {
        HouseDTO houseWithNoRooms = HouseDTO.builder().rooms(List.of()).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(houseWithNoRooms)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test con habitaciones con dimensiones inválidas (0)")
    void testCalculateWithInvalidRoomDimensions() throws Exception {
        RoomDTO invalidRoom = RoomDTO.builder().width(0).length(10).build();
        HouseDTO houseWithInvalidRoom = HouseDTO.builder()
                .rooms(List.of(invalidRoom))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(houseWithInvalidRoom)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test con habitaciones con dimensiones inválidas (negativas)")
    void testCalculateWithNegativeRoomDimensions() throws Exception {
        RoomDTO invalidRoom = RoomDTO.builder().width(-5).length(10).build();
        HouseDTO houseWithInvalidRoom = HouseDTO.builder()
                .rooms(List.of(invalidRoom))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(houseWithInvalidRoom)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test con solo una habitación")
    void testCalculateWithOneRoom() throws Exception {
        HouseDTO houseWithOneRoom = HouseDTO.builder()
                .rooms(List.of(room1))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(houseWithOneRoom)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(80000)) // 10 * 10 * 800
                .andExpect(jsonPath("$.biggest.width").value(room1.getWidth()))
                .andExpect(jsonPath("$.biggest.length").value(room1.getLength()))
                .andExpect(jsonPath("$.squareFeet").value(100)); // 10 * 10
    }
}