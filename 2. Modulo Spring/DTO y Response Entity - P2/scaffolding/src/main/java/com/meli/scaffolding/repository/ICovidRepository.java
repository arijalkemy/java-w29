package com.meli.scaffolding.repository;

import com.meli.scaffolding.entities.Persona;
import com.meli.scaffolding.entities.Sintoma;

import java.util.List;
import java.util.Optional;

public interface ICovidRepository {
    List<Sintoma> getSintomas();
    Integer nivelDeGravedad(String name);
    Optional<Sintoma> getByName(String name);
    List<Persona> getPersonas();
}
