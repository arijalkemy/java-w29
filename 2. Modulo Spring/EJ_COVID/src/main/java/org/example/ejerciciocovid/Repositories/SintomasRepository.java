package org.example.ejerciciocovid.Repositories;

import org.example.ejerciciocovid.Entities.Sintoma;

import java.util.List;
import java.util.Optional;

public interface SintomasRepository {

    List<Sintoma> getAll();

    Optional<Sintoma> getByName(String name);

}
