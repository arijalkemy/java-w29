package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTests {

    @Mock
    private CharacterRepository repository;

    @InjectMocks
    private FindService service;

    @Test
    void find() {
        final CharacterDTO characterDTO = getCharacterDTO();
        when(repository.findAllByNameContains(characterDTO.getName())).thenReturn(List.of(characterDTO));

        final List<CharacterDTO> result = service.find(characterDTO.getName());
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(characterDTO, result.getFirst());
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
