package com.example.numerosromanos.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Service test")
class NumerosRomanosServiceImplTest {

    private final NumerosRomanosServiceImpl service = new NumerosRomanosServiceImpl();

    @ParameterizedTest
    @CsvFileSource(resources = "/numeros_romanos.csv", numLinesToSkip = 1)
    void decimalToRomanTest(Integer decimal, String expectedRoman) {
        String actualRoman = service.decimalToRoman(decimal);
        assertEquals(expectedRoman, actualRoman);
    }
}