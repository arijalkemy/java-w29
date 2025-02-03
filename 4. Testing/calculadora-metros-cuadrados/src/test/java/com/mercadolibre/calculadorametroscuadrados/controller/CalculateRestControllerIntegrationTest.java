package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CalculateService service;

    ObjectMapper mapper =new ObjectMapper();

    @Test
    void testOne() throws Exception {
        HouseResponseDTO respuestaesperada = new HouseResponseDTO(
                "Casa de ejemplo",
                "123 Calle Falsa, Ciudad",
                Arrays.asList(
                        new RoomDTO("Living Room", 5, 4),
                        new RoomDTO("Bedroom", 4, 3),
                        new RoomDTO("Kitchen", 3, 3)
                ),
                41, // Metros cuadrados totales
                32800, // Precio total
                new RoomDTO("Living Room", 5, 4) // Habitación más grande
        );

        HouseDTO params =new HouseDTO(
                "Casa de ejemplo",
                "123 Calle Falsa, Ciudad",
                Arrays.asList(
                        new RoomDTO("Living Room", 5, 4),
                        new RoomDTO("Bedroom", 4, 3),
                        new RoomDTO("Kitchen", 3, 3)
                )
        );

        calculateIT(respuestaesperada,params);

    }



    private void calculateIT (HouseResponseDTO resultEsperado, HouseDTO params) throws Exception {
        when(service.calculate(params)).thenReturn(resultEsperado);

        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(params)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.address").value(resultEsperado.getAddress()))
                .andExpect(jsonPath("$.price").value(resultEsperado.getPrice()))
                .andExpect(jsonPath("$.squareFeet").value(resultEsperado.getSquareFeet()))
                .andExpect(jsonPath("$.biggest.name").value(resultEsperado.getBiggest().getName()))
                .andExpect(jsonPath("$.rooms[0].name").value(resultEsperado.getRooms().get(0).getName()))
                .andExpect(jsonPath("$.rooms[1].name").value(resultEsperado.getRooms().get(1).getName()));
    }
}
