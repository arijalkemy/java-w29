package com.mercadolibre.romannumerals.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumeralsRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenNumber1_whenToRoman_thenReturnI() throws Exception {
        int number = 1;
        mockMvc.perform(get("/" + number))
                .andExpect(status().isOk())
                .andExpect(content().string("I"));
    }

    @Test
    void givenNumber3_whenToRoman_thenReturnIII() throws Exception {
        int number = 3;
        mockMvc.perform(get("/" + number))
                .andExpect(status().isOk())
                .andExpect(content().string("III"));
    }

    @Test
    void givenNumber5_whenToRoman_thenReturnV() throws Exception {
        int number = 5;
        mockMvc.perform(get("/" + number))
                .andExpect(status().isOk())
                .andExpect(content().string("V"));
    }

    @Test
    void givenNumber7_whenToRoman_thenReturnVII() throws Exception {
        int number = 7;
        mockMvc.perform(get("/" + number))
                .andExpect(status().isOk())
                .andExpect(content().string("VII"));
    }

    @Test
    void givenNumber10_whenToRoman_thenReturnX() throws Exception {
        int number = 10;
        mockMvc.perform(get("/" + number))
                .andExpect(status().isOk())
                .andExpect(content().string("X"));
    }

    @Test
    void givenNumber50_whenToRoman_thenReturnL() throws Exception {
        int number = 50;
        mockMvc.perform(get("/" + number))
                .andExpect(status().isOk())
                .andExpect(content().string("L"));
    }




}
