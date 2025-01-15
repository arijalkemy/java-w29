package com.example.deportistas.repositories;

import com.example.deportistas.enums.Nivel;
import com.example.deportistas.models.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class DeportesRepositoryImpl implements DeportesRepository {

    private final List<Deporte> deportes = new ArrayList<>(List.of(
            new Deporte("Fútbol", Nivel.AVANZADO),
            new Deporte("Baloncesto", Nivel.INTERMEDIO),
            new Deporte("Natación", Nivel.PRINCIPIANTE),
            new Deporte("Tenis", Nivel.AVANZADO),
            new Deporte("Ciclismo", Nivel.INTERMEDIO)
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

    @Override
    public Deporte getRandomSport() {
        Random random = new Random();
        return deportes.get(random.nextInt(deportes.size()));
    }

}
