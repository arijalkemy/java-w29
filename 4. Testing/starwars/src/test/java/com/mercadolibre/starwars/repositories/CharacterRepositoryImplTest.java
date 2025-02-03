package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository;

    @BeforeEach
    void setUp(){
        this.characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContainsOkTest() {
        //arrange
        String query = "darth";
        //act
        List<CharacterDTO> response = characterRepository.findAllByNameContains(query);
        //assert
        assertEquals(2, response.size());
    }
}