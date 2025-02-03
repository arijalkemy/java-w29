package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIT {

    @Autowired
    private FindService findService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenValidQuery_whenFind_thenReturnCharacterList() throws Exception {
        String query = "Darth Maul";
        mockMvc.perform(get("/" + query))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].name", everyItem(containsStringIgnoringCase(query))));
    }

    @Test
    void givenEmptyQuery_whenFind_thenReturnEmptyList() throws Exception {
        String query = "";
        mockMvc.perform(get("/" + query))
                .andExpect(status().isNotFound());
    }
}
