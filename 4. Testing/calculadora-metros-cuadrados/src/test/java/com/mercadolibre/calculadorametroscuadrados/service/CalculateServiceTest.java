package com.mercadolibre.calculadorametroscuadrados.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.util.HouseFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @InjectMocks
    private CalculateService calculateService;

    @Test
    void givenValidHouse_whenCalculate_thenCalculateCorrectBiggestDimensions() {
        HouseDTO house = HouseFactory.buildHouse();
        RoomDTO expectedBigRoom = HouseFactory.buildBigRoom();

        HouseResponseDTO houseResponse = calculateService.calculate(house);

        assertEquals(expectedBigRoom, houseResponse.getBiggest());
    }

    @Test
    void givenValidHouse_whenCalculate_thenCalculateCorrectSquareFeet() {
        HouseDTO house = HouseFactory.buildHouse();

        HouseResponseDTO houseResponse = calculateService.calculate(house);

        assertEquals(2600, houseResponse.getSquareFeet());
    }

    @Test
    void givenValidHouse_whenCalculate_thenCalculateCorrectPrice() {
        HouseDTO house = HouseFactory.buildHouse();

        HouseResponseDTO houseResponse = calculateService.calculate(house);

        assertEquals(2600*800, houseResponse.getPrice());

    }

    @Test
    void givenHouseWithNoRooms_whenCalculate_thenReturnZeroSquareFeetAndNullBiggest() {
        HouseDTO house = HouseFactory.buildHouseWithNoRooms();

        HouseResponseDTO houseResponse = calculateService.calculate(house);

        assertEquals(0, houseResponse.getSquareFeet());
        assertNull(houseResponse.getBiggest());
    }

    @Test
    void givenHouseWithNoRooms_whenCalculate_thenReturnZeroPrice() {
        HouseDTO house = HouseFactory.buildHouseWithNoRooms();

        HouseResponseDTO houseResponse = calculateService.calculate(house);

        assertEquals(0, houseResponse.getPrice());
    }
}
