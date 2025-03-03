package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @InjectMocks
    CalculateService calculateService;

    @Test
    @DisplayName("Test del método calculate")
    void calculateTest(){
        //arrange
        HouseDTO houseDTO = new HouseDTO("House Test", "Dirección", List.of(
                new RoomDTO("Living", 6, 5),
                new RoomDTO("Dormitorio", 5, 5),
                new RoomDTO("Cocina", 4, 5),
                new RoomDTO("Baño", 3, 3)
        ));

        RoomDTO biggest = new RoomDTO("Living", 6, 5);

        HouseResponseDTO expectedResponse = new HouseResponseDTO("House Test", "Dirección", List.of(
                new RoomDTO("Living", 6, 5),
                new RoomDTO("Dormitorio", 5, 5),
                new RoomDTO("Cocina", 4, 5),
                new RoomDTO("Baño", 3, 3)
        ), 84, 67200, biggest);

        //act
        HouseResponseDTO response = calculateService.calculate(houseDTO);

        //assert
        assertNotNull(response);
        assertEquals(response, expectedResponse);

    }
}
