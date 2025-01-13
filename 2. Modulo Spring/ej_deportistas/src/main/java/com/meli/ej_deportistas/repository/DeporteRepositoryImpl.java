package com.meli.ej_deportistas.repository;

import com.meli.ej_deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DeporteRepositoryImpl implements DeporteRepository {

    private final List<Deporte> deportes = new ArrayList<>();

    public DeporteRepositoryImpl() {
        this.deportes.add(new Deporte("Futbol", "Aficionado"));
        this.deportes.add(new Deporte("Baloncesto", "Semiprofesional"));
        this.deportes.add(new Deporte("Voleibol", "Aficionado"));
        this.deportes.add(new Deporte("Tenis", "Semiprofesional"));
        this.deportes.add(new Deporte("Ultimate", "Aficionado"));
    }
    @Override
    public List<Deporte> findAll() {
        return this.deportes;
    }

    @Override
    public Optional<Deporte> findByNombre(String nombre) {
        return this.deportes.stream()
                .filter(dep -> dep.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }
}
