package org.example.covid_19.repository;

import lombok.AllArgsConstructor;
import lombok.Data;


import org.example.covid_19.entity.Sintoma;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class SintomaRepository {
    private List<Sintoma> sintomas;

    public SintomaRepository() {
        this.sintomas = new ArrayList<>();
        // Agrega algunos síntomas a la lista inicial
        sintomas.add(new Sintoma("001", "Fiebre", "Alta"));  // El código ahora es un String
        sintomas.add(new Sintoma("002", "Tos", "Media"));    // El código ahora es un String
        // Agrega más síntomas según sea necesario
    }

    public List<Sintoma> findAll() {
        return sintomas;
    }

    public Sintoma findByName(String name) {
        return sintomas.stream()
                .filter(s -> s.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}