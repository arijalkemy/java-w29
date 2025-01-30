package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {

    @Mock
    private CalculateService service;

    @InjectMocks
    private CalculateRestController controller;

    @Test
    @DisplayName("Unit test calculate")
    void testCalculate() {
        HouseDTO houseDTO = new HouseDTO();
        controller.calculate(houseDTO);
        verify(service).calculate(houseDTO);
    }
}