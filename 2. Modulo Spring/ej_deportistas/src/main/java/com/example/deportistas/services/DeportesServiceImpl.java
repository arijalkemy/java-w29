package com.example.deportistas.services;

import com.example.deportistas.models.Deporte;
import com.example.deportistas.repositories.DeportesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DeportesServiceImpl implements DeportesService {

    private final DeportesRepository deporteRepository;

    @Override
    public List<Deporte> getAllDeportes() {
        return deporteRepository.findAll();
    }

    @Override
    public Deporte getByName(String name) {
        return deporteRepository.findByNombre(name)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el deporte"));
    }
}
