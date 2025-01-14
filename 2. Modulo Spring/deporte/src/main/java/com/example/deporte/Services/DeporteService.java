package com.example.deporte.Services;

import com.example.deporte.DeporteApplication;
import com.example.deporte.Models.Deporte;
import com.example.deporte.Repositories.DeporteRepository;
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
