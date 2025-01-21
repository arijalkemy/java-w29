package com.bootcamp.repository;

import com.bootcamp.model.Personaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository {

    private List<Personaje> personajes;

    {
        personajes = new ArrayList<>();
        personajes.add(new Personaje("Luke Skywalker"));
        personajes.add(new Personaje("Darth Vader"));
        personajes.add(new Personaje("Darth Maul"));
        personajes.add(new Personaje("Leia Organa"));
        personajes.add(new Personaje("Han Solo"));
    }

    @Override
    public List<Personaje> findByText(String text) {
        return personajes.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }
}
