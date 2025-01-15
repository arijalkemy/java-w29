package com.mercadolibre.javawave29.star_wars.service;

import com.mercadolibre.javawave29.star_wars.dto.CharacterDTO;
import com.mercadolibre.javawave29.star_wars.mapper.StarWarsMapper;
import com.mercadolibre.javawave29.star_wars.model.StarWarsCharacter;
import com.mercadolibre.javawave29.star_wars.repository.IRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService implements IService{

    private final IRepository repository;
    private final StarWarsMapper mapper;

    public StarWarsService (IRepository repository) {
        this.repository = repository;
        mapper = new StarWarsMapper();
    }

    @Override
    public ResponseEntity<List<CharacterDTO>> getCharacters() {
        List<StarWarsCharacter> characters = repository.getCharacters();
        if (characters.isEmpty()) return ResponseEntity.noContent().build();
        List<CharacterDTO> charactersDTO = mapCharactersToDTO(characters);
        return ResponseEntity.ok(charactersDTO);
    }

    @Override
    public ResponseEntity<List<CharacterDTO>> getCharactersByName(String name) {
        List<StarWarsCharacter> characters = repository.getCharactersByName(name);
        if (characters.isEmpty()) return ResponseEntity.noContent().build();
        List<CharacterDTO> charactersDTO = mapCharactersToDTO(characters);
        return ResponseEntity.ok(charactersDTO);
    }

    private List<CharacterDTO> mapCharactersToDTO(List<StarWarsCharacter> starWarsCharacters) {
        return starWarsCharacters
                .stream()
                .map(mapper::characterToDTO)
                .toList();
    }

    @Override
    public ResponseEntity<CharacterDTO> addCharacter(StarWarsCharacter character) {
        if (!repository.save(character)) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(mapper.characterToDTO(character));
    }
}
