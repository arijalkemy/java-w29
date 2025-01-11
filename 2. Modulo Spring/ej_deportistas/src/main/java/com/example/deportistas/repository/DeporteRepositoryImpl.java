package com.example.deportistas.repository;

import com.example.deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DeporteRepositoryImpl implements DeporteRepository {

    private final List<Deporte> deportes = new ArrayList<>(List.of(
            new Deporte("Fútbol", "Avanzado"),
            new Deporte("Baloncesto", "Intermedio"),
            new Deporte("Natación", "Principiante"),
            new Deporte("Tenis", "Avanzado"),
            new Deporte("Ciclismo", "Intermedio")
    ));


    @Override
    public List<Deporte> getAll() {
        return deportes;
    }

    @Override
    public Optional<Deporte> findByNombre(String nombre) {
        return deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

}
