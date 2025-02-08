package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RomanNumeralsRestControllerTest {
    @InjectMocks
    RomanNumeralsRestController romanNumeralsRestController;

    @Test
    void toRomanTest(){
        Integer number = 10;
        String expected = "X";

        String actual = romanNumeralsRestController.toRoman(number);

        assertEquals(expected, actual);
    }

    @Test
    void toRomanTestWithAppend(){
        Integer number = 15;
        String expected = "XV";

        String actual = romanNumeralsRestController.toRoman(number);

        assertEquals(expected, actual);
    }

    @Test
    void toRomanTestNotOk(){
        Integer number = 0;
        String expected = "";

        String actual = romanNumeralsRestController.toRoman(number);

        assertEquals(expected, actual);
    }

}
