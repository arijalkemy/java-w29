package org.example.ej_edad_persona.Services;

import lombok.RequiredArgsConstructor;
import org.example.ej_edad_persona.Dtos.FechaNacimientoDto;
import org.example.ej_edad_persona.Entities.Persona;
import org.example.ej_edad_persona.Repositories.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {



    private final PersonaRepository repo;

    private long maxId = 1L;


    @Override
    public Integer calcularEdad(Integer dia, Integer mes, Integer anio) {
        Persona persona = Persona.builder()
                .fechaNacimiento(FechaNacimientoDto.toLocalDate(dia,mes,anio))
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
        Optional<Persona> persona = repo.findById(personaId);
        if(persona.isEmpty()) throw new NoSuchElementException("Persona no encontraada");

        return persona.get().calcularEdad();
    }
}

