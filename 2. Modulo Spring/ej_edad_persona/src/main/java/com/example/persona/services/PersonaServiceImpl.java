package com.example.persona.services;

import com.example.persona.dtos.FechaNacimientoDto;
import com.example.persona.entities.Persona;
import com.example.persona.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository repo;

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
                .fechaNacimiento(fechaNacimiento.toLocalDate())
                .build();
        repo.save(persona);
        return persona;
    }

    @Override
    public Integer getEdad(Long personaId) {
        Persona persona = repo
                .findById(personaId)
                .orElseThrow(() -> new NoSuchElementException("Persona no encontrada"));
        return persona.calcularEdad();
    }
}
