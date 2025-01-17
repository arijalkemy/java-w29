package com.meli.scaffolding.service;

import com.meli.scaffolding.dto.CharacterDto;
import com.meli.scaffolding.repositories.ICharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICharacterService {
  private final ICharacterRepository characterRepository;

  public ICharacterService(ICharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  public List<CharacterDto> find(String query) {
    return characterRepository.findAllByNameContains(query);
  }
}
