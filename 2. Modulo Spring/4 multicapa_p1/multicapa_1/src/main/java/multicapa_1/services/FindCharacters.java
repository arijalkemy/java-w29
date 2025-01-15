package multicapa_1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import multicapa_1.repositories.CharacterRepo;

import multicapa_1.entities.Character;

@Service
@RequiredArgsConstructor
public class FindCharacters {
  private final CharacterRepo characterRepo;

  public List<Character> findByName(String name){
    return characterRepo.getCharacters().stream()
      .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
      .toList();
  }
}
