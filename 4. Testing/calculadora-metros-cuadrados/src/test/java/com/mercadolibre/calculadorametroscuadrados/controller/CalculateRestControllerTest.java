package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {

    @InjectMocks
    CalculateRestController calculateRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void calculate() {
        //arrange

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

        HouseResponseDTO houseResponseDTOExpected = new HouseResponseDTO(houseDTO);
        houseResponseDTOExpected.setBiggest(r2);
        houseResponseDTOExpected.setPrice(40000000);
        houseResponseDTOExpected.setSquareFeet(50000);

        //act
        HouseResponseDTO houseResponseDTOActual = calculateRestController.calculate(houseDTO);

        //assert
        assertEquals(houseResponseDTOExpected.getPrice(), houseResponseDTOActual.getPrice());

    }
}