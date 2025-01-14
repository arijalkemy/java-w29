package com.meli.starwars.repository;


import com.meli.starwars.model.Personaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository {

    List<Personaje> personajes;

    public PersonajeRepository() {
        this.personajes = new ArrayList<>();
    }

    public List<Personaje> searchByName(String name) {
        String nameLower = name.toLowerCase();

        return personajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(nameLower))
                .toList();
    }

}
