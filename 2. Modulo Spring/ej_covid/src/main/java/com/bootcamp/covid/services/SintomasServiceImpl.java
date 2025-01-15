package com.bootcamp.covid.services;

import com.bootcamp.covid.dtos.SintomaDto;
import com.bootcamp.covid.entities.Sintoma;
import com.bootcamp.covid.repositories.SintomasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SintomasServiceImpl implements SintomasService {

    private final SintomasRepository sintomaRepository;

    @Override
    public List<SintomaDto> getAllSintomas() {
        return sintomaRepository.getAll().stream().map(SintomaDto::toDto).toList();
    }

    @Override
    public String findGravedadByName(String name) {
        Sintoma sintoma = sintomaRepository
                .getByName(name)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el síntoma " + name));

        return sintoma.getNivelDeGravedad().getString();
    }

}
