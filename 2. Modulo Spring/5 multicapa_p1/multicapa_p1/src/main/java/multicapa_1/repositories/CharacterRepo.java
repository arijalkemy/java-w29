package multicapa_1.repositories;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import multicapa_1.entities.Character;

@Repository
public class CharacterRepo {
  private static List<Character> characters;

  public CharacterRepo(){
    ObjectMapper mapper = new ObjectMapper();
    try {
      InputStream inputStream = CharacterRepo.class.getClassLoader().getResourceAsStream("starwars.json");
      CharacterRepo.characters = mapper.readValue(inputStream, new TypeReference<List<Character>>(){});
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Character> getCharacters() {
    return CharacterRepo.characters;
  }
}
