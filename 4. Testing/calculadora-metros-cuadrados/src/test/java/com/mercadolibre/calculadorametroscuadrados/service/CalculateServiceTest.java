package com.mercadolibre.calculadorametroscuadrados.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculateServiceTest {
    private final CalculateService calculateService = new CalculateService();

    @Test
    void testCalculateSquareFeetAndBiggestRoom() {
        // Arrange
        RoomDTO room1 = new RoomDTO("Room1", 20, 20);
        RoomDTO room2 = new RoomDTO("Room2", 30, 30);
        RoomDTO room3 = new RoomDTO("Room3", 25, 25);

        HouseDTO house = new HouseDTO("Camilo", "AK 68 # 1 - 63", List.of(room1, room2, room3));

        // Act
        HouseResponseDTO response = calculateService.calculate(house);

        // Assert
        assertEquals(1925, response.getSquareFeet(), "Total square feet calculation is incorrect");
        assertNotNull(response.getBiggest(), "Biggest room should not be null");
        assertEquals(room2.getName(), response.getBiggest().getName(), "Biggest room calculation is incorrect");
        assertEquals(900, response.getBiggest().getSquareFeet(), "Biggest room square feet is incorrect");
    }

    @Test
    void testCalculatePrice() {
        // Arrange
        RoomDTO room1 = new RoomDTO("Room1", 15, 15);
        RoomDTO room2 = new RoomDTO("Room2", 25, 25);

        HouseDTO house = new HouseDTO("Camilo", "AK 68 # 1 - 63", Arrays.asList(room1, room2));

        // Act
        HouseResponseDTO response = calculateService.calculate(house);

        // Assert
        assertEquals(680000, response.getPrice(), "Price calculation is incorrect");
    }
}
