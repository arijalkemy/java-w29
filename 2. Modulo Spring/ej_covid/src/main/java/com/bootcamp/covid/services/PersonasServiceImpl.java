package com.bootcamp.covid.services;

import com.bootcamp.covid.dtos.PersonaRiesgoDto;
import com.bootcamp.covid.repositories.PersonasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonasServiceImpl implements PersonasService {

    private final PersonasRepository personaRepository;

    @Override
    public List<PersonaRiesgoDto> getPersonasRiesgo() {
        return personaRepository.getAll().stream()
                .filter(p -> p.getEdad() >= 60 && !p.getSintomas().isEmpty())
                .map(PersonaRiesgoDto::toDto)
                .toList();
    }

}
