package exercise.starwars.service;

import exercise.starwars.dto.response.CharacterResponseDto;

import java.util.List;

public interface ICharacterService {
    List<CharacterResponseDto> getCharactersByName(String search);
}
