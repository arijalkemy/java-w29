package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsRestControllerTest {

    private static RomanNumeralsRestController restController;

    @BeforeAll
    static void setUp() {
        restController = new RomanNumeralsRestController();
    }

    @Test
    @DisplayName("Parse number to roman number")
    void toRomanTest() {
        String expectedNumber = "II";
        Integer number = 2;

        String response = restController.toRoman(number);

        assertEquals(expectedNumber, response);
    }

    @Test
    @DisplayName("Parse number not valid negative number")
    void toRomanNotValidNegativeNumberTest() {
        Integer number = -2;

        String response = restController.toRoman(number);
        assertTrue(response.isBlank());
    }
}