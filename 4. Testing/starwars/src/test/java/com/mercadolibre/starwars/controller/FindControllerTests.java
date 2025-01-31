package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class FindControllerTests {

    @Autowired
    private FindController controller;

    @Mock
    private FindService service;

    @Test
    void find() {
        final CharacterDTO characterDTO = getCharacterDTO();
        when(service.find(anyString())).thenReturn(List.of(characterDTO));

        assertDoesNotThrow(() -> controller.find(characterDTO.getName()));

        List<CharacterDTO> result = controller.find(characterDTO.getName());
        assertEquals(List.of(characterDTO).getFirst(), result.getFirst());
    }

    private CharacterDTO getCharacterDTO() {
        final CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("male");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("Human");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        return characterDTO;
    }
}
