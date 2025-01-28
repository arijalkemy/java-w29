package org.example.covid_19.services;

import org.example.covid_19.dots.PersonaYSintomaDto;
import org.example.covid_19.entity.Sintoma;
import org.example.covid_19.repository.PersonaRepository;
import org.example.covid_19.repository.SintomaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaludService {
    private final SintomaRepository sintomaRepository;
    private final PersonaRepository personaRepository;

    public SaludService(SintomaRepository sintomaRepository, PersonaRepository personaRepository) {
        this.sintomaRepository = sintomaRepository;
        this.personaRepository = personaRepository;
    }

    public List<Sintoma> findAllSymptoms() {
        return sintomaRepository.findAll();
    }

    public ResponseEntity<String> findSymptomByName(String name) {
        Sintoma sintoma = sintomaRepository.findByName(name);
        return sintoma != null
                ? ResponseEntity.ok("Nivel de gravedad: " + sintoma.getNivelDeGravedad())
                : ResponseEntity.notFound().build();
    }

    public List<PersonaYSintomaDto> findRiskPersons() {
        return personaRepository.findAll().stream()
                .filter(persona -> persona.getEdad() > 60 && !persona.getSintomas().isEmpty())
                .map(persona -> {
                    // Asumiendo que tomamos el primer síntoma para el DTO
                    Sintoma sintoma = persona.getSintomas().getFirst();
                    String fullName = persona.getNombre() + " " + persona.getApellido();
                    return new PersonaYSintomaDto(fullName, persona.getEdad(), sintoma.getNombre());
                })
                .collect(Collectors.toList());
    }
}
