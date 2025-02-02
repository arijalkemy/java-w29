package com.mercadolibre.starwars.controller;


//Se requiere crear los tests de integración necesarios para cubrir el comportamiento de la capa de controladores
//FindController. Tener en cuenta la mayor cantidad de escenarios posibles.

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindService findService;

    @Test
    void testOneadmé() throws Exception{
        List<CharacterDTO> personajesEsperados = Arrays.asList(
                new CharacterDTO("Padmé Amidala", "brown", "light", "brown", "46BBY", "female", "Naboo", "Human", 165, 45)
        );
        findIntTest("admé",personajesEsperados);
    }

    @Test
    void testTwoLuke() throws Exception{
        List<CharacterDTO> personajesEsperados = Arrays.asList(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77)
        );
        findIntTest("Luke",personajesEsperados);
    }

    @Test
    void testThreeArt() throws Exception{
        List<CharacterDTO> personajesEsperados = Arrays.asList(
                new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80),
                new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136)
        );
        findIntTest("art",personajesEsperados);
    }

    private void findIntTest(String query, List<CharacterDTO> listPersonajes) throws Exception{

        when(findService.find(query)).thenReturn(listPersonajes);


        this.mockMvc.perform(get("/" +query))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    private void findIntTestNotFound(String query, List<CharacterDTO> listPersonajes) throws Exception{

        when(findService.find(query)).thenReturn(listPersonajes);


        this.mockMvc.perform(get("/" +query))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }



}

