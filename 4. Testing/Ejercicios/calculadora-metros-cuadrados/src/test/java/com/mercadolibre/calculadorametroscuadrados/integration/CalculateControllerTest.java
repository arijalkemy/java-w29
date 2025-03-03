package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class CalculateControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private HouseDTO houseDTO;
    private RoomDTO biggest;

    @BeforeEach
    void setUp() {
        houseDTO = new HouseDTO("House Test", "Dirección", List.of(
                new RoomDTO("Living", 6, 5),
                new RoomDTO("Dormitorio", 5, 5),
                new RoomDTO("Cocina", 4, 5),
                new RoomDTO("Baño", 3, 3)
        ));

        biggest = new RoomDTO("Living", 6, 5);
    }

    @Test
    void calculate() throws Exception{

        HouseResponseDTO expectedResponse = new HouseResponseDTO("House Test", "Dirección", List.of(
                new RoomDTO("Living", 6, 5),
                new RoomDTO("Dormitorio", 5, 5),
                new RoomDTO("Cocina", 4, 5),
                new RoomDTO("Baño", 3, 3)
        ), 84, 67200, biggest);

        MvcResult result = mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(houseDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        HouseResponseDTO response = objectMapper.readValue(responseBody, HouseResponseDTO.class);

        assertEquals(expectedResponse, response);
    }

}
