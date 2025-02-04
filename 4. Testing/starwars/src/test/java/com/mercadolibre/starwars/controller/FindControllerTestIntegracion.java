package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class FindControllerTestIntegracion {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private FindService findService;

    @Test
    public void testFind() throws Exception {
        List<CharacterDTO> characters = Arrays.asList(new CharacterDTO("Luke Skywalker"));
        when(findService.find("Luke")).thenReturn(characters);

        this.mockMvc.perform(get("/Luke"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$[0].name").value(containsString("Luke")));
//            .andExpect(content().string(containsString("Luke")));
//            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Luke Skywalker"));
    }
}
