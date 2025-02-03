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

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {
    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    @Test
    void calculateControllerUnitTest () {
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

        when(service.calculate(params)).thenReturn(respuestaesperada);
        //act
        HouseResponseDTO respuesta = controller.calculate(params);

        // Verificar el resultado
        assertEquals(respuestaesperada, respuesta);  // Compara el resultado esperado y el obtenido

        // Verificar que el servicio fue llamado una vez con el HouseDTO correcto
        verify(service, times(1)).calculate(params);
    }

}