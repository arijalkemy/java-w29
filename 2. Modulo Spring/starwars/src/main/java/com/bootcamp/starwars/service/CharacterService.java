package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.entity.Character;
import com.bootcamp.starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    public List<CharacterDTO> getAllCharacters(){
        return characterRepository.getAllCharacters().stream().map(this::buildCharacterDto).toList();
    }
    public List<CharacterDTO> getCharacterByName(String name){
        List<Character> characters = characterRepository.getCharacterByName(name);
        return characters.stream().map(this::buildCharacterDto).toList();
    }
    private CharacterDTO buildCharacterDto(Character character){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(character.getName());
        characterDTO.setMass(character.getMass());
        characterDTO.setHeight(character.getHeight());
        characterDTO.setGender(character.getGender());
        characterDTO.setHomeworld(character.getHomeworld());
        characterDTO.setSpecies(character.getSpecies());
        characterDTO.setBirthYear(character.getBirthYear());
        return characterDTO;
    }
}
