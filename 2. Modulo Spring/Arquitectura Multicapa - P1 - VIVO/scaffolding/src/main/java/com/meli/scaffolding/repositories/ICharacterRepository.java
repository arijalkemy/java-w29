package com.meli.scaffolding.repositories;

import com.meli.scaffolding.dto.CharacterDto;

import java.util.List;

public interface ICharacterRepository {
    List<CharacterDto> findAllByNameContains(String query);
}
