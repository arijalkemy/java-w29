package com.example.persona.services;

import com.example.persona.dtos.FechaNacimientoDto;
import com.example.persona.entities.Persona;
import com.example.persona.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository repo;

    private Long maxId = 1L;

    @Override
    public Integer calcularEdad(Integer dia, Integer mes, Integer anio) {
        Persona persona = Persona.builder()
                .fechaNacimiento(FechaNacimientoDto.toLocalDate(dia, mes, anio))
                .build();
        return persona.calcularEdad();
    }

    @Override
    public Persona addPersona(FechaNacimientoDto fechaNacimiento) {
        Persona persona = Persona.builder()
                .id(maxId++)
                .fechaNacimiento(fechaNacimiento.toLocalDate())
                .build();
        repo.save(persona);
        return persona;
    }

    @Override
    public Integer getEdad(Long personaId) {
        Optional<Persona> persona = repo.getById(personaId);
        if (persona.isEmpty()) throw new NoSuchElementException("Persona no encontrada");
        return persona.get().calcularEdad();
    }

}
