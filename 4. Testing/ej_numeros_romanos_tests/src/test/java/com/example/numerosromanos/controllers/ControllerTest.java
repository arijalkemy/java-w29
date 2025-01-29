package com.example.numerosromanos.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvFileSource(resources = "/numeros_romanos.csv", numLinesToSkip = 1)
    void decimalToRomanTest(Integer decimal, String expectedRoman) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{numeroDecimal}", decimal))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedRoman));
    }

    @Test
    void decimalToRomanTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{numeroDecimal}", 0))
                .andExpect(status().isBadRequest());
        mockMvc.perform(MockMvcRequestBuilders.get("/{numeroDecimal}", -1))
                .andExpect(status().isBadRequest());
    }
}
