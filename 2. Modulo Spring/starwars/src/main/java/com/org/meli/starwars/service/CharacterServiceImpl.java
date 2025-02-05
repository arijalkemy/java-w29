package com.org.meli.starwars.service;

import com.org.meli.starwars.dto.CharacterDto;
import com.org.meli.starwars.entity.Character;
import com.org.meli.starwars.exception.NotFoundException;
import com.org.meli.starwars.repository.ICharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements IServiceCharacter {

    private final ICharacterRepository characterRepository;

    public CharacterServiceImpl(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDto> findCharacterByName(String name) {
        List <Character> characters = characterRepository.findCharacterByName(name);
        if(characters.isEmpty()) {
            throw new NotFoundException("El personaje con nombre " + name + " no fue encontrado");
        }

        List<CharacterDto> characterDtos = characters.stream()
                .map(character -> new CharacterDto(character.getName(), character.getHeight(), character.getMass(), character.getGender(), character.getHomeworld(), character.getSpecies()))
                .toList();
        return characterDtos;
    }
}
