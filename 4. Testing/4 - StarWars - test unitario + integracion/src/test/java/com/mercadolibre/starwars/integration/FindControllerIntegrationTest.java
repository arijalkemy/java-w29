package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findCharacter_whenExists_returnList() throws Exception {
        String name = "Luke";
        CharacterDTO luke = CharacterDTO
                .builder()
                .name("Luke Skywalker")
                .height(172)
                .mass(77)
                .hair_color("blond")
                .skin_color("fair")
                .eye_color("blue")
                .birth_year("19BBY")
                .gender("male")
                .homeworld("Tatooine")
                .species("Human")
                .build();

        List<CharacterDTO> expected = List.of(luke);

        // act and assert
        mockMvc.perform(get("/{query}", name))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value(expected.get(0).getName()));
    }

    @Test
    void findCharacter_whenExists_returnListEmpty() throws Exception {
        String name = "name";

        List<CharacterDTO> expected = List.of();

        // act and assert
        mockMvc.perform(get("/{query}", name))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isEmpty());
    }
}
