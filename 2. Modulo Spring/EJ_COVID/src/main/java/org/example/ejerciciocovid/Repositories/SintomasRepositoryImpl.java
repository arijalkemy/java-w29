package org.example.ejerciciocovid.Repositories;

import org.example.ejerciciocovid.Entities.Sintoma;
import org.example.ejerciciocovid.Enums.NivelGravedad;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SintomasRepositoryImpl implements SintomasRepository {

    private final List<Sintoma> sintomas = new ArrayList<>(List.of(
            new Sintoma(1, "Fiebre", NivelGravedad.ALTO),
            new Sintoma(2, "Tos", NivelGravedad.MEDIO),
            new Sintoma(3, "Dolor de cabeza", NivelGravedad.BAJO),
            new Sintoma(4, "Fatiga", NivelGravedad.MEDIO),
            new Sintoma(5, "Dificultad para respirar", NivelGravedad.ALTO)
    ));

    @Override
    public List<Sintoma> getAll() {
        return sintomas;
    }

    @Override
    public Optional<Sintoma> getByName(String name) {
        return sintomas.stream()
                .filter(s -> s.getNombre().equals(name))
                .findFirst();
    }
}
