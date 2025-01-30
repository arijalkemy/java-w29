package com.example.numerosromanos.controllers;

import com.example.numerosromanos.services.NumerosRomanosService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    private NumerosRomanosService numerosRomanosService;

    @InjectMocks
    private Controller controller;

    @Test
    @DisplayName("Test unitario controller")
    public void testController() {
        controller.convertir(1);
        verify(numerosRomanosService).decimalToRoman(1);
    }
}
