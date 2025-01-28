package com.bootcamp.covid.services;

import com.bootcamp.covid.dtos.SintomaDto;
import com.bootcamp.covid.entities.Sintoma;
import com.bootcamp.covid.repositories.SintomasRepository;
import com.bootcamp.covid.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SintomasServiceImpl implements SintomasService {

    private final SintomasRepository sintomaRepository;

    @Override
    public List<SintomaDto> getAllSintomas() {
        return sintomaRepository.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public String findGravedadByName(String name) {
        Sintoma sintoma = sintomaRepository
                .findByName(name)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el síntoma " + name));

        return sintoma.getNivelDeGravedad().getString();
    }
}
