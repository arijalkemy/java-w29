package com.meli.ej_starwars.repository;

import com.meli.ej_starwars.model.Personaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository {
    private final List<Personaje> personajes;

    public PersonajeRepositoryImpl() {
        this.personajes = List.of(
                new Personaje("Luke Skywalker", 172, 77, "Rubio", "Clara", "Azules", 19, "Masculino", "Tatooine", "Humano"),
                new Personaje("Leia Organa", 150, 49, "Castaño", "Clara", "Marrones", 19, "Femenino", "Alderaan", "Humano"),
                new Personaje("Han Solo", 180, 80, "Castaño", "Clara", "Marrones", 29, "Masculino", "Corellia", "Humano"),
                new Personaje("Darth Vader", 202, 136, "Sin Cabello", "Pálida", "Amarillos", 41, "Masculino", "Tatooine", "Humano"),
                new Personaje("Darth Maul", 198, 136, "Sin Cabello", "Pálida", "Amarillos", 49, "Masculino", "Tatooine", "Humano"),
                new Personaje("Yoda", 66, 17, "Blanco", "Verde", "Verdes", 900, "Masculino", "Desconocido", "Yoda's species"),
                new Personaje("Palpatine", 170, 75, "Blanco", "Pálida", "Amarillos", 82, "Masculino", "Naboo", "Humano"),
                new Personaje("Chewbacca", 228, 112, "Marrón", "Marrón", "Azules", 200, "Masculino", "Kashyyyk", "Wookiee"),
                new Personaje("R2-D2", 96, 32, "Sin Cabello", "Metálico", "Rojo/Azul", 33, "Sin Género", "Naboo", "Droide")
        );
    }

    @Override
    public List<Personaje> findAll() {
        return this.personajes;
    }
}
