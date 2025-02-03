package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {
    @InjectMocks
    CalculateService service;

    @Test
    void calculateTestUnit(){
        //arrange
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

        //act
        HouseResponseDTO resultado = service.calculate(params);

        //assertions
        assertEquals(respuestaesperada.getPrice(), resultado.getPrice());
        assertEquals(respuestaesperada.getBiggest(), resultado.getBiggest());
        assertEquals(respuestaesperada.getSquareFeet(), resultado.getSquareFeet());
        assertEquals(20,resultado.getRooms().get(0).getSquareFeet());
        assertEquals(12,resultado.getRooms().get(1).getSquareFeet());
        assertEquals(9,resultado.getRooms().get(2).getSquareFeet());

    }

}