package com.meli.numerosromanos.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NumeroRomanoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void oneToI() throws Exception {
        this.performTest(1, "I");
    }

    @Test
    public void fourToIV() throws Exception {
        this.performTest(4, "IV");
    }

    @Test
    public void nineToIX() throws Exception {
        this.performTest(9, "IX");
    }

    @Test
    public void tenToX() throws Exception {
        this.performTest(10, "X");
    }

    @Test
    public void fortyToXL() throws Exception {
        this.performTest(40, "XL");
    }

    @Test
    public void fiftToL() throws Exception {
        this.performTest(50, "L");
    }

    @Test
    public void ninetyToXC() throws Exception {
        this.performTest(90, "XC");
    }

    @Test
    public void oneHundredToC() throws Exception {
        this.performTest(100, "C");
    }

    @Test
    public void fiveHundredToD() throws Exception {
        this.performTest(500, "D");
    }

    @Test
    public void nineHundredToCM() throws Exception {
        this.performTest(900, "CM");
    }

    @Test
    public void thousandToM() throws Exception {
        this.performTest(1000, "M");
    }

    @Test
    public void extra() throws Exception {
        this.performTest(1234, "MCCXXXIV");
    }

    private void performTest(Integer decimal, String roman) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/" + decimal))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(roman));
    }

}
