package com.spring.star_wars.service;

import com.spring.star_wars.dto.SWCharacterDTO;
import com.spring.star_wars.model.SWCharacter;
import com.spring.star_wars.repository.StarWarsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsServiceImpl implements StarWarsService{

    @Autowired
    StarWarsRepositoryImpl starWarsRepository;

    @Override
    public List<SWCharacterDTO> findCharactersNamed(String partialName) {
        System.out.println(starWarsRepository.getCharacters());
        return starWarsRepository.getCharactersNamed(partialName).stream()
                .map(this::mapToDTO)
                .toList();
    }

    private SWCharacterDTO mapToDTO(SWCharacter character) {
        return new SWCharacterDTO(
                character.name(),
                character.height(),
                character.mass(),
                character.gender(),
                character.homeWorld(),
                character.species()
        );
    }
}
