package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CalculateServiceTest {


    @Test
    @DisplayName("calculate Square Feet- test Ok")
    void calculateSquareFeet() {
        //arrange
        CalculateService calculateService = new CalculateService();

        RoomDTO r1 = new RoomDTO();
        r1.setName("habitacion 1");
        r1.setLength(200);
        r1.setWidth(100);

        RoomDTO r2 = new RoomDTO();
        r2.setName("habitacion 1");
        r1.setLength(300);
        r2.setWidth(100);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Casa Manuel");
        houseDTO.setAddress("prueba");
        houseDTO.setRooms(List.of(r1, r2));

        //act
        HouseResponseDTO houseResponseDTOActual = calculateService.calculate(houseDTO);

        //assert
        assertEquals(30000, houseResponseDTOActual.getSquareFeet());

    }

    @Test
    @DisplayName("calculate the big Room- test Ok")
    void calculateRoomSquareFeet() {
        //arrange
        CalculateService calculateService = new CalculateService();

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

        //act
        HouseResponseDTO houseResponseDTOActual = calculateService.calculate(houseDTO);

        //assert
        assertEquals(r2, houseResponseDTOActual.getBiggest());

    }

    @Test
    @DisplayName("calculate price House- test Ok")
    void calculatePrice() {
        //arrange
        CalculateService calculateService = new CalculateService();

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

        //act
        HouseResponseDTO houseResponseDTOActual = calculateService.calculate(houseDTO);

        //assert
        assertEquals(40000000, houseResponseDTOActual.getPrice());

    }
}