package com.bootcamp.excercise.service;

import com.bootcamp.excercise.entity.Persona;
import com.bootcamp.excercise.entity.PersonaRiesgoDto;
import com.bootcamp.excercise.entity.Sintoma;
import com.bootcamp.excercise.repository.PersonaRepository;
import com.bootcamp.excercise.repository.SintomaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaludServiceImpl implements SaludService{
    private final PersonaRepository personaRepository;
    private final SintomaRepository sintomaRepository;

    public SaludServiceImpl(PersonaRepository personaRepository, SintomaRepository sintomaRepository) {
        this.personaRepository = personaRepository;
        this.sintomaRepository = sintomaRepository;
    }

    @Override
    public List<Sintoma> getAllSyntomps() {
        return sintomaRepository.findAllSymptoms();
    }

    @Override
    public String getSymptomLevel(String nombre) {
        Sintoma sintoma = sintomaRepository.findByName(nombre);
        if(sintoma != null){
            return sintoma.getNivelDeGravedad();
        }
        return "Sintoma no encontrado";
    }

    @Override
    public List<PersonaRiesgoDto> getRiskPersons() {
        List<PersonaRiesgoDto> personasDeRiesgo = new ArrayList<>();
        List<Persona> personas = personaRepository.findPersonsWithSymptoms();
        for (Persona persona : personas) {
            personasDeRiesgo.add(new PersonaRiesgoDto(persona.getNombre(), persona.getApellido()));
        }
        return personasDeRiesgo;
    }
}
