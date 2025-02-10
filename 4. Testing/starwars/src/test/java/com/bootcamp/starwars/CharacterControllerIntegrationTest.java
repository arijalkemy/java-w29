package com.bootcamp.starwars;


import com.bootcamp.starwars.dto.CharacterDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAllCharacters() throws Exception {
        MvcResult result = mockMvc.perform(get("/characters"))
            .andExpect(status().isOk())
            .andReturn();
        Integer size = objectMapper.readValue(result.getResponse().getContentAsString(), List.class).size();
        assertEquals(87, size);
    }

    @Test
    public void getCharacterByName() throws Exception {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        characterDTO.setBirthYear("19BBY");
        characterDTO.setGender("male");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("Human");
        String expected = objectMapper.writeValueAsString(List.of(characterDTO));

        MvcResult result = mockMvc.perform(get("/characters/{name}", "Luke"))
            .andExpect(status().isOk())
            .andReturn();
        assertEquals(expected, result.getResponse().getContentAsString());
    }

}
