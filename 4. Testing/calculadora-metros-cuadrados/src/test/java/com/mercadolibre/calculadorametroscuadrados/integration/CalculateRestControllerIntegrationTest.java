package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("test calculate Ok")
    void calculate() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        
        RoomDTO r1 = new RoomDTO();
        r1.setName("habitacion 1");
        r1.setLength(200);
        r1.setWidth(100);

        RoomDTO r2 = new RoomDTO();
        r2.setName("habitacion 2");
        r2.setLength(300);
        r2.setWidth(100);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Casa Manuel");
        houseDTO.setAddress("prueba");
        houseDTO.setRooms(List.of(r1, r2));


        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(houseDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.squareFeet").value(50000))
                .andExpect(jsonPath("$.price").value(40000000));


    }
}
