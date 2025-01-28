package com.bootcamp.covid.repositories;

import com.bootcamp.covid.entities.Sintoma;

import java.util.List;
import java.util.Optional;

public interface SintomasRepository {
    List<Sintoma> findAll();

    Optional<Sintoma> findByName(String name);
}
