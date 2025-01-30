package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    private static final CalculateService service = new CalculateService();

    RoomDTO room1 = RoomDTO.builder().width(10).length(10).build();
    RoomDTO room2 = RoomDTO.builder().width(20).length(10).build();
    RoomDTO room3 = RoomDTO.builder().width(20).length(30).build();
    RoomDTO invalidRoomZero = RoomDTO.builder().width(0).length(10).build();
    RoomDTO invalidRoomNegative = RoomDTO.builder().width(-5).length(10).build();

    HouseDTO house = HouseDTO.builder()
            .rooms(List.of(room1, room2, room3))
            .build();

    @Test
    @DisplayName("Verificar el cálculo del valor de la propiedad")
    void testCalculatePrice() {
        HouseResponseDTO result = service.calculate(house);
        assertEquals(720000, result.getPrice());
    }

    @Test
    @DisplayName("Verificar que la habitación con las mayores dimensiones sea considerada la más grande")
    void testCalculateBiggestRoom() {
        HouseResponseDTO result = service.calculate(house);
        assertEquals(room3, result.getBiggest());
    }

    @Test
    @DisplayName("Verificar la cantidad de metros cuadrados por habitación")
    void testGetSquareFeet() {
        HouseResponseDTO result = service.calculate(house);

        assertEquals(100, room1.getSquareFeet());
        assertEquals(200, room2.getSquareFeet());
        assertEquals(600, room3.getSquareFeet());
        assertEquals(900, result.getSquareFeet());
    }

    @Test
    @DisplayName("Test con casa sin habitaciones")
    void testCalculateWithNoRooms() {
        HouseDTO houseWithNoRooms = HouseDTO.builder().rooms(List.of()).build();
        assertThrows(IllegalArgumentException.class, () -> service.calculate(houseWithNoRooms));
    }

    @Test
    @DisplayName("Test con habitaciones con dimensiones inválidas (0)")
    void testCalculateWithInvalidRoomDimensionsZero() {
        HouseDTO houseWithInvalidRoom = HouseDTO.builder()
                .rooms(List.of(invalidRoomZero))
                .build();
        assertThrows(IllegalArgumentException.class, () -> service.calculate(houseWithInvalidRoom));
    }

    @Test
    @DisplayName("Test con habitaciones con dimensiones inválidas (negativas)")
    void testCalculateWithInvalidRoomDimensionsNegative() {
        HouseDTO houseWithInvalidRoom = HouseDTO.builder()
                .rooms(List.of(invalidRoomNegative))
                .build();

        assertThrows(IllegalArgumentException.class, () -> service.calculate(houseWithInvalidRoom));
    }
}
