package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterRepositoryImplTests {
    CharacterRepositoryImpl repository = new CharacterRepositoryImpl();

    @BeforeEach
    public void setup() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/test/resources/Base_starwars.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        String json = "[\n" +
                "  {\n" +
                "    \"name\": \"Luke Skywalker\",\n" +
                "    \"hair_color\": \"Blond\",\n" +
                "    \"skin_color\": \"Fair\",\n" +
                "    \"eye_color\": \"Blue\",\n" +
                "    \"birth_year\": \"19BBY\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"homeworld\": \"Tatooine\",\n" +
                "    \"species\": \"Human\",\n" +
                "    \"height\": 172,\n" +
                "    \"mass\": 77\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Darth Vader\",\n" +
                "    \"hair_color\": \"None\",\n" +
                "    \"skin_color\": \"Pale\",\n" +
                "    \"eye_color\": \"Yellow\",\n" +
                "    \"birth_year\": \"41.9BBY\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"homeworld\": \"Tatooine\",\n" +
                "    \"species\": \"Human\",\n" +
                "    \"height\": 202,\n" +
                "    \"mass\": 136\n" +
                "  }\n" +
                "]";

        writer.print(json);
        writer.close();
    }

    @Test
    public void findAllByNameContains() {
        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke.setHair_color("Blond");
        luke.setSkin_color("Fair");
        luke.setEye_color("Blue");
        luke.setBirth_year("19BBY");
        luke.setGender("Male");
        luke.setHomeworld("Tatooine");
        luke.setSpecies("Human");
        luke.setHeight(172);
        luke.setMass(77);

        String query = "Luke";
        List<CharacterDTO> expected = List.of(luke);

        List<CharacterDTO> actual = repository.findAllByNameContains(query);

        assertEquals(expected, actual);
    }

}
