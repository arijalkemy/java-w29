package com.meli.deportistas.services;

import com.meli.deportistas.model.DeporteModel;
import com.meli.deportistas.repository.DeporteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeporteService {
    public List<DeporteModel> getAllDeportes() {
        DeporteRepository deporteRepository = new DeporteRepository();
        return deporteRepository.deportes;
    }

    public Optional<DeporteModel> getDeporteByName(String name) {
        DeporteRepository deporteRepository = new DeporteRepository();
        return deporteRepository.deportes.stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(name))
                .findFirst();
    }
}