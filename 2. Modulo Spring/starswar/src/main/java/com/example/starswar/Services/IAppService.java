package com.example.starswar.Services;

import com.example.starswar.DTO.CharacterDTO;

import java.util.List;

public interface IAppService {
    List<CharacterDTO> getCharacterWithName(String name);
}
