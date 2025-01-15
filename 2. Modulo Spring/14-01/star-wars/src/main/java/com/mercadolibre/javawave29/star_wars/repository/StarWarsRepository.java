package com.mercadolibre.javawave29.star_wars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.javawave29.star_wars.model.StarWarsCharacter;
import org.springframework.stereotype.Repository;
import java.io.InputStream;
import java.util.List;

@Repository
public class StarWarsRepository implements IRepository{

    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<StarWarsCharacter> characters;

    public StarWarsRepository() {
        loadCharacters();
    }

    private void loadCharacters() {
        try (InputStream inputStream = getClass().getResourceAsStream("/characters.json")) {
            if (inputStream == null) {
                throw new RuntimeException("El archivo JSON no se pudo encontrar en el classpath.");
            }
            characters = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar el archivo JSON", e);
        }
    }


    @Override
    public List<StarWarsCharacter> getCharacters() {
        return characters;
    }

    @Override
    public List<StarWarsCharacter> getCharactersByName(String name) {
        return characters
                .stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    @Override
    public boolean save(StarWarsCharacter character) {
        return characters.add(character);
    }
}
