package com.meli.ej_deportistas.service;

import com.meli.ej_deportistas.dto.PersonaDeporteDTO;
import com.meli.ej_deportistas.model.Deporte;
import com.meli.ej_deportistas.model.Persona;
import com.meli.ej_deportistas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;
    private final DeporteService deporteService;

    @Autowired
    public PersonaService(
            PersonaRepository personaRepository,
            DeporteService deporteService) {
        this.personaRepository = personaRepository;
        this.deporteService = deporteService;
        this.initData();

    }

    private void initData() {
        Deporte futbol = this.deporteService.findByNombre("Futbol");
        Deporte baloncesto = this.deporteService.findByNombre("Baloncesto");
        Deporte tenis = this.deporteService.findByNombre("Tenis");

        this.personaRepository.save(new Persona("Jorge", "Perez", 24, futbol));
        this.personaRepository.save(new Persona("Andres", "Gomez", 21, baloncesto));
        this.personaRepository.save(new Persona("Paula", "Castro", 20, tenis));
        this.personaRepository.save(new Persona("Laura", "Pineda", 28, futbol));
        this.personaRepository.save(new Persona("Raul", "Perez", 19, tenis));

    }

    public List<PersonaDeporteDTO> findAllPersonasDeportistas() {
        return this.personaRepository.findAll().stream()
                .map(persona -> new PersonaDeporteDTO(
                        persona.getNombre(),
                        persona.getApellido(),
                        persona.getDeporte().getNombre()
                ))
                .toList();
    }


}
