package dev.stars_wars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.stars_wars.dto.PersonajeDto;
import dev.stars_wars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PersonajesService {
    private List<Personaje> personajes;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public PersonajesService() {
        /*this.personajes = new ArrayList<>(List.of(
            new Personaje("Luke Skywalker", 172, 77, "Blond", "Fair", "Blue", "19BBY", "Male", "Tatooine", "Human"),
            new Personaje("Leia Organa", 150, 49, "Brown", "Light", "Brown", "19BBY", "Female", "Alderaan", "Human"),
            new Personaje("Han Solo", 180, 80, "Brown", "Fair", "Brown", "29BBY", "Male", "Corellia", "Human"),
            new Personaje("Darth Vader", 202, 136, "None", "White", "Yellow", "41.9BBY", "Male", "Tatooine", "Human"),
            new Personaje("Yoda", 66, 17, "White", "Green", "Brown", "896BBY", "Male", "Unknown", "Yoda's species"),
            new Personaje("Chewbacca", 228, 112, "Brown", "Unknown", "Blue", "200BBY", "Male", "Kashyyyk", "Wookiee"),
            new Personaje("Darth Maul", 175, 80, "None", "Red", "Yellow", "54BBY", "Male", "Dathomir", "Zabrak")
        ));*/

        this.personajes = new ArrayList<>();
        this.cargarPersonajes();
    }

    private void cargarPersonajes(){
        try{
            File file = new File("src/main/resources/starwars.json");
            this.personajes.addAll(this.objectMapper.readValue(file, new TypeReference<List<Personaje>>(){ }));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<PersonajeDto> getNamesContains(String name){
        return personajes.stream()
                .filter(personaje -> personaje.getName().contains(name))
                .map(p -> new PersonajeDto(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies()))
                .collect(Collectors.toList());
    }

}
