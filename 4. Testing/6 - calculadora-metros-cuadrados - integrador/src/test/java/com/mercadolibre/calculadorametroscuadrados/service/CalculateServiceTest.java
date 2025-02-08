package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {
    @InjectMocks
    CalculateService calculateService;

    @Test
    void calculateTest(){
        // arrange
        HouseDTO entry = new HouseDTO(
                "My House",
                "123 Street Name",
                List.of(
                        new RoomDTO("Living Room", 5, 7),
                        new RoomDTO("Bedroom", 4, 5)
                )
        );

        HouseResponseDTO expected = new HouseResponseDTO(55, 44000, new RoomDTO("Living Room", 5, 7));

        // act
        HouseResponseDTO actual = calculateService.calculate(entry);

        // assert
        assertEquals(expected.getPrice(), actual.getPrice());
        assertEquals(expected.getBiggest(), actual.getBiggest());
        assertEquals(expected.getSquareFeet(), actual.getSquareFeet());
        assertEquals(35,actual.getRooms().get(0).getSquareFeet());
        assertEquals(20,actual.getRooms().get(1).getSquareFeet());

    }

    @Test
    void calculateTest_notok(){
        // arrange
        HouseDTO entry = new HouseDTO(
                "My House",
                "123 Street Name",
                List.of()
        );

        HouseResponseDTO expected = new HouseResponseDTO(0, 0, null);

        // act
        HouseResponseDTO actual = calculateService.calculate(entry);

        // assert
        assertEquals(expected, actual);
    }
}
