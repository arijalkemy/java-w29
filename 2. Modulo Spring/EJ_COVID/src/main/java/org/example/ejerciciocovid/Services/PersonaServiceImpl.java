package org.example.ejerciciocovid.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ejerciciocovid.Dtos.PersonaRiesgoDto;
import org.example.ejerciciocovid.Entities.Persona;
import org.example.ejerciciocovid.Repositories.PersonaRepository;
import org.example.ejerciciocovid.Repositories.PersonaRepositoryImpl;

import java.util.List;

public class PersonaServiceImpl implements PersonaService{

    private final PersonaRepositoryImpl repository;

    public PersonaServiceImpl(PersonaRepositoryImpl  repository)
    {
        this.repository = repository;
    }

    @Override
    public List<PersonaRiesgoDto> getPersonasRiesgo() {
        ObjectMapper mapper = new ObjectMapper();
        List<Persona> personas = repository.getAll();
        return personas.stream().map(v -> mapper.convertValue(v,PersonaRiesgoDto.class))
                .toList();
    }
}
