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
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
    @Mock
    CalculateService calculateService;
    @InjectMocks
    CalculateRestController calculateRestController;

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

        when(calculateService.calculate(entry)).thenReturn(expected);

        // act
        HouseResponseDTO actual = calculateRestController.calculate(entry);

        // assert
        assertEquals(expected, actual);
        verify(calculateService, times(1)).calculate(entry);
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

        when(calculateService.calculate(entry)).thenReturn(expected);
        // act
        HouseResponseDTO actual = calculateRestController.calculate(entry);

        // assert
        assertEquals(expected, actual);
        verify(calculateService, times(1)).calculate(entry);
    }
}
