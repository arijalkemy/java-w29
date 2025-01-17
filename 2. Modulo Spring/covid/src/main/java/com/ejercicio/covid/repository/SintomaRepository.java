package com.ejercicio.covid.repository;

import com.ejercicio.covid.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SintomaRepository {
    private List<Sintoma> sintomas;

    public SintomaRepository(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public void addSintoma(Sintoma sintoma) {
        sintomas.add(sintoma);
    }

    public List<Sintoma> findAll() {
        return this.sintomas;
    }

    public Optional<Sintoma> findByName(String name) {
        return this.sintomas.stream().filter(s -> s.getNombre().equals(name)).findFirst();
    }
}
