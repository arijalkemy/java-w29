package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
    @Mock
    private CalculateService calculateService;

    @InjectMocks
    private CalculateRestController calculateRestController;

    @Test
    void calculateTest() {
        // Arrange
        RoomDTO room1 = new RoomDTO("Room1", 10, 10);
        HouseDTO house = new HouseDTO("Camilo", "AK 68 # 1 - 63", List.of(room1));

        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);
        expectedResponse.setSquareFeet(100);
        expectedResponse.setPrice(80000);
        expectedResponse.setBiggest(room1);
        // Act
//        when(calculateService.calculate(house)).thenReturn(expectedResponse);
        var response = calculateRestController.calculate(house);

        // Assert
        assertEquals(expectedResponse.getPrice(), response.getPrice(), "Price is incorrect");
    }
}
