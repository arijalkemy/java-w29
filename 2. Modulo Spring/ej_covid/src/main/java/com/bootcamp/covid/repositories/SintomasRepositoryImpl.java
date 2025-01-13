package com.bootcamp.covid.repositories;

import com.bootcamp.covid.entities.Sintoma;
import com.bootcamp.covid.enums.NivelDeGravedad;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SintomasRepositoryImpl implements SintomasRepository {

    private final List<Sintoma> sintomas = new ArrayList<>(List.of(
            new Sintoma(1, "Fiebre", NivelDeGravedad.ALTO),
            new Sintoma(2, "Tos", NivelDeGravedad.MEDIO),
            new Sintoma(3, "Dolor de cabeza", NivelDeGravedad.BAJO),
            new Sintoma(4, "Fatiga", NivelDeGravedad.MEDIO),
            new Sintoma(5, "Dificultad para respirar", NivelDeGravedad.ALTO)
        ));

    @Override
    public List<Sintoma> getAll() {
        return sintomas;
    }

    @Override
    public Optional<Sintoma> getByName(String name) {
        return sintomas.stream()
                .filter(s -> s.getNombre().equalsIgnoreCase(name))
                .findFirst();
    }

}
