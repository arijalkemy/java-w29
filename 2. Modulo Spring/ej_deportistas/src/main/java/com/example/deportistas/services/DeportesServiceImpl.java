package com.example.deportistas.services;

import com.example.deportistas.models.Deporte;
import com.example.deportistas.repositories.DeportesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeportesServiceImpl implements DeportesService {

    private final DeportesRepository deporteRepository;

    @Override
    public List<Deporte> getAllDeportes() {
        return deporteRepository.getAll();
    }

    @Override
    public Deporte findByName(String name) {
        Optional<Deporte> optionalDeporte = deporteRepository.findByNombre(name);

        if (optionalDeporte.isEmpty()) {
            throw new NoSuchElementException("No se encontró el deporte");
        }

        return optionalDeporte.get();
    }

}
