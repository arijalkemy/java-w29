package com.thiagoschreck.local.star_wars_api.service;

import com.thiagoschreck.local.star_wars_api.dto.response.CharacterResponseDTO;
import com.thiagoschreck.local.star_wars_api.entity.Character;
import com.thiagoschreck.local.star_wars_api.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {

    private final ICharacterRepository repository;

    @Autowired
    public CharacterServiceImpl(ICharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CharacterResponseDTO> getAllCharacters() {
        return repository.getAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<CharacterResponseDTO> getCharactersByName(String name) {
        if (name == null || name.isBlank()) {
            return getAllCharacters();
        }
        return repository.getByName(name).stream()
                .map(this::mapToDTO)
                .toList();
    }

    private CharacterResponseDTO mapToDTO(Character character) {
        Integer height = null;
        Integer mass = null;
        try {
            height = Integer.parseInt(character.height());
            mass = Integer.parseInt(character.mass());
        } catch (NumberFormatException _) {
        }
        return new CharacterResponseDTO(character.name(), height, mass, character.gender(), character.homeworld(), character.species());
    }
}
