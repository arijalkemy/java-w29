package com.meli.deportitas.service;

import com.meli.deportitas.model.Deporte;
import com.meli.deportitas.repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService {

    @Autowired
    private DeporteRepository deporteRepository;

    public List<Deporte> findAll() {
        return deporteRepository.getDeportes();
    }

    public Deporte findByNombre(String nombre) {
        return deporteRepository.getDeportes().stream().filter(x -> x.getNombre().equals(nombre)).findFirst().orElse(null);
    }
}
