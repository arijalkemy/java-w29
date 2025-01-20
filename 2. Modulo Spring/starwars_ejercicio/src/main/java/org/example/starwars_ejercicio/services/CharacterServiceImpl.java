package org.example.starwars_ejercicio.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars_ejercicio.dto.CharacterDTO;
import org.example.starwars_ejercicio.models.Character;
import org.example.starwars_ejercicio.repositories.CharacterRepositoryImpl;
import org.example.starwars_ejercicio.repositories.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {


    @Autowired
    private ICharacterRepository characterRepository;
    @Autowired
    private CharacterRepositoryImpl characterRepositoryImpl;

    @Override
    public List<CharacterDTO> getCharacters() {
        return characterRepository.getAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<CharacterDTO> getCharactersForWord(String word) {
        ObjectMapper objectMapper = new ObjectMapper();

        return characterRepository.getCharacterByName(word).stream().map(c-> objectMapper.convertValue(c,CharacterDTO.class)).toList();
    }

    public CharacterDTO mapToDTO(Character character) {

        return new CharacterDTO(
                character.getName(),
                character.getHeight(),
                character.getMass(),
                character.getGender(),
                character.getHomeworld(),
                character.getSpecies()
        );

    }

}
