package multicapa_1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import multicapa_1.repositories.CharacterRepo;
import multicapa_1.dtos.responseCharacterDto;

@Service
@RequiredArgsConstructor
public class CharactersService implements ICharactersService {
  private final CharacterRepo characterRepo;

  public List<responseCharacterDto> findByName(String name) {
    ObjectMapper objectMapper = new ObjectMapper();
    return characterRepo.getCharacters().stream()
        .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
        .map(character -> objectMapper.convertValue(character, responseCharacterDto.class))
        .toList();
  }
}
