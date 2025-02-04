package repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterRepositoryTest {

    CharacterRepository characterRepository;

    @BeforeEach
    void setup(){
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContainsOkTest(){
        CharacterDTO characterDTO = new CharacterDTO("Luke Skywalker", "blond", "fair",
                "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);

        List<CharacterDTO> characterDTOS = List.of(characterDTO);

        var result = characterRepository.findAllByNameContains("Luke");

        //assertEquals(characterDTOS.size(), result.size()); SIN EQUALS en CharacterDTO
        assertEquals(characterDTOS, result); //Agregando el equals a mano o el @Data si tenemos lombok
    }
}
