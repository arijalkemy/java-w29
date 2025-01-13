package com.meli.ej_deportistas.service;

import com.meli.ej_deportistas.model.Deporte;
import com.meli.ej_deportistas.repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService {

    private final DeporteRepository deporteRepository;

    @Autowired
    public DeporteService(DeporteRepository deporteRepository) {
        this.deporteRepository = deporteRepository;
    }

    public List<Deporte> findAll() {
        return this.deporteRepository.findAll();
    }

    public Deporte findByNombre(String nombreDeporte) {
        return this.deporteRepository.findByNombre(nombreDeporte)
                .orElseThrow(() -> new IllegalArgumentException("deporte no encontrado"));

    }
}
