package org.example.calcular_calorias.repositories;

import org.example.calcular_calorias.entities.Platos;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlatoRepository implements IPlatoRepository {

    private final IPlatoRepository platoRepository; // Utiliza la interfaz

    // Constructor que recibe la implementación del repositorio
    public PlatoRepository(IPlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    @Override
    public List<Platos> obtenerPlatos() {
        return platoRepository.obtenerPlatos(); // Delegar la llamada
    }

    @Override
    public Platos buscarPlatoPorNombre(String nombre) {
        return platoRepository.buscarPlatoPorNombre(nombre); // Delegar la llamada
    }
}