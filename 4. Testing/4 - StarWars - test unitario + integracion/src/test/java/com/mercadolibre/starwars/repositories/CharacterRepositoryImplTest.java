package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterRepositoryImplTest {
    private CharacterRepository characterRepository = new CharacterRepositoryImpl();

    @Test
    @DisplayName("Find all by name - ok")
    void findAllByNameContainsTest_ok(){
        String name = "Luke";
        CharacterDTO expected = CharacterDTO
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

        List<CharacterDTO> actual = characterRepository.findAllByNameContains(name);

        assertTrue(actual.contains(expected));
        assertEquals(Integer.valueOf(1), actual.size());
    }

    @Test
    @DisplayName("Find all by name - not exists")
    void findAllByNameContainsTest_notOk(){
        String name = "name";

        List<CharacterDTO> actual = characterRepository.findAllByNameContains(name);

        assertEquals(Integer.valueOf(0), actual.size());
    }

}
