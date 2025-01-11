package com.example.deportistas.service;

import com.example.deportistas.dto.DeportistaDto;
import com.example.deportistas.mapper.DeportistaDtoMapper;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.repository.DeporteRepositoryImpl;
import com.example.deportistas.repository.PersonaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeportistaService {

    private final DeportistaDtoMapper mapper;

    private final DeporteRepositoryImpl deporteRepository;

    private final PersonaRepositoryImpl personaRepository;

    @Autowired
    public DeportistaService(
            DeportistaDtoMapper mapper,
            DeporteRepositoryImpl deporteRepository,
            PersonaRepositoryImpl personaRepository
    ) {
        this.mapper = mapper;
        this.deporteRepository = deporteRepository;
        this.personaRepository = personaRepository;
    }

    public List<Deporte> getAllDeportes() {
        return deporteRepository.getAll();
    }

    public Deporte findByName(String name) {
        Optional<Deporte> optionalDeporte = deporteRepository.findByNombre(name);

        if (optionalDeporte.isEmpty()) {
            throw new IllegalArgumentException("No se encontró el deporte");
        }

        return optionalDeporte.get();
    }

    public List<DeportistaDto> getAllPersonas() {
        return personaRepository.getAll().stream().map(mapper).toList();
    }
}
