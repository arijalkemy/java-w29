package spring.ejerciciostarwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import spring.ejerciciostarwars.model.Personaje;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Repository
public class PersonajeRepository implements IPersonajeRepository {

    private List<Personaje> personajes;

    public PersonajeRepository() throws IOException {
        try {
            final File jsonFile = new ClassPathResource("starwars.json").getFile();
            final ObjectMapper objectMapper = new ObjectMapper();
            personajes = objectMapper.readValue(jsonFile, new TypeReference<>() {
            });

        } catch (IOException e) {
            System.out.println(e.getMessage());
            personajes = Collections.emptyList();
        }
    }

    @Override
    public List<Personaje> findByName(String name) {
        return personajes.stream()
                .filter(personaje -> personaje.name().toUpperCase()
                        .contains(name.toUpperCase())).toList();
    }
}
