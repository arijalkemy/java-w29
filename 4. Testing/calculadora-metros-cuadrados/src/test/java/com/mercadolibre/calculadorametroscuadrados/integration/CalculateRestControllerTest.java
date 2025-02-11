package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Test
    void calculateTest() throws Exception {
        RoomDTO room1 = new RoomDTO("Room1", 10, 10);

        HouseDTO house = new HouseDTO("Camilo", "AK 68 # 1 - 63", List.of(room1));

        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(house);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(house.getName()))
                .andExpect(jsonPath("$.price").value(80000))
                .andExpect(jsonPath("$.squareFeet").value(100));
    }
}