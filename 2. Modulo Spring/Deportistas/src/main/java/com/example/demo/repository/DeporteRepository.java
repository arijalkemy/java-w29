package com.example.demo.repository;

import com.example.demo.model.Deporte;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class DeporteRepository implements IDeporteRepository {
    List<Deporte> deportes;

    public DeporteRepository() {
        deportes = new ArrayList<>();

        deportes.add(new Deporte("Fútbol", 1));
        deportes.add(new Deporte("Baloncesto", 2));
        deportes.add(new Deporte("Tenis", 3));
        deportes.add(new Deporte("Natación", 4));
    }

    public List<Deporte> encontrarTodos() {
        return deportes;
    }

    public Deporte encontrarPorNombre(String nombre) {
        return deportes.stream()
                .filter((d) -> d.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}
