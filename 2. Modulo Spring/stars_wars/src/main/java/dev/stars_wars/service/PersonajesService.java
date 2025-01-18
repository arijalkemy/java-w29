package dev.stars_wars.service;

import dev.stars_wars.dto.PersonajeDto;
import dev.stars_wars.entity.Personaje;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PersonajesService {
    private List<Personaje> personajes;

    public PersonajesService() {
        this.personajes = new ArrayList<>(List.of(
            new Personaje("Luke Skywalker", 172, 77, "Blond", "Fair", "Blue", "19BBY", "Male", "Tatooine", "Human"),
            new Personaje("Leia Organa", 150, 49, "Brown", "Light", "Brown", "19BBY", "Female", "Alderaan", "Human"),
            new Personaje("Han Solo", 180, 80, "Brown", "Fair", "Brown", "29BBY", "Male", "Corellia", "Human"),
            new Personaje("Darth Vader", 202, 136, "None", "White", "Yellow", "41.9BBY", "Male", "Tatooine", "Human"),
            new Personaje("Yoda", 66, 17, "White", "Green", "Brown", "896BBY", "Male", "Unknown", "Yoda's species"),
            new Personaje("Chewbacca", 228, 112, "Brown", "Unknown", "Blue", "200BBY", "Male", "Kashyyyk", "Wookiee"),
            new Personaje("Darth Maul", 175, 80, "None", "Red", "Yellow", "54BBY", "Male", "Dathomir", "Zabrak")
        ));
    }

    public List<PersonajeDto> getNamesContains(String name){
        return personajes.stream()
                .filter(personaje -> personaje.getName().contains(name))
                .map(p -> new PersonajeDto(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies()))
                .collect(Collectors.toList());
    }

}
