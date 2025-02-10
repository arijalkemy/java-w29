package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterRepositoryTest {

    CharacterRepository characterRepository;

    @BeforeEach
    public void setup(){
        characterRepository = new CharacterRepository("src/test/resources/static/starwars.json");
    }

    @Test
    public void getAllCharactersTest(){
        Character character = new Character();
        character.setName("Luke Skywalker");
        character.setHeight(172);
        character.setMass(77);
        character.setHairColor("blond");
        character.setSkinColor("fair");
        character.setEyeColor("blue");
        character.setBirthYear("19BBY");
        character.setGender("male");
        character.setHomeworld("Tatooine");
        character.setSpecies("Human");
        List<Character> expected = List.of(character);

        List<Character> actual = characterRepository.getAllCharacters();

        assertEquals(expected, actual);
    }

    @Test
    public void getAllCharactersEmptyTest(){
        CharacterRepository characterRepository = new CharacterRepository("");
        List<Character> expected = List.of();
        List<Character> actual = characterRepository.getAllCharacters();
        assertEquals(expected, actual);
    }

    @Test
    public void getCharacterByNameTest() {
        Character character = new Character();
        character.setName("Luke Skywalker");
        character.setHeight(172);
        character.setMass(77);
        character.setHairColor("blond");
        character.setSkinColor("fair");
        character.setEyeColor("blue");
        character.setBirthYear("19BBY");
        character.setGender("male");
        character.setHomeworld("Tatooine");
        character.setSpecies("Human");
        List<Character> expected = List.of(character);

        List<Character> actual = characterRepository.getCharacterByName("luke");
        assertEquals(expected, actual);
    }
    @Test
    public void getCharacterByNameEmptyTest() {
        List<Character> expected = List.of();
        List<Character> actual = characterRepository.getCharacterByName("nonexistent");
        assertEquals(expected, actual);
    }
}
