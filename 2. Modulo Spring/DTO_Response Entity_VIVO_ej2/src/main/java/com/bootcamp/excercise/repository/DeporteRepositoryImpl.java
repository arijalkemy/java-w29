package com.bootcamp.excercise.repository;

import com.bootcamp.excercise.entity.DeporteEntity;
import com.bootcamp.excercise.entity.PersonaEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepositoryImpl implements IDeporteRepository{
    private List<DeporteEntity> deportes;
    private List<PersonaEntity> personas;

    public DeporteRepositoryImpl() {
        this.deportes = new ArrayList<>();
        this.personas = new ArrayList<>();
        personas.add(new PersonaEntity("Juan", "Pérez", 25));
        personas.add(new PersonaEntity("Ana", "González", 30));
        personas.add(new PersonaEntity("Luis", "Martínez", 22));
        deportes.add(new DeporteEntity("Fútbol", "Avanzado"));
        deportes.add(new DeporteEntity("Básquetbol", "Intermedio"));
        deportes.add(new DeporteEntity("Natación", "Principiante"));
    }

    @Override
    public List<DeporteEntity> findAllSports() {
        return deportes;
    }

    @Override
    public List<PersonaEntity> findAllPersons() {
        return personas;
    }

    @Override
    public DeporteEntity findSportByName(String nombre) {
        return deportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
    }
}
