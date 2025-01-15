package com.meli.deportistas.services;

import com.meli.deportistas.dto.PersonaDto;
import com.meli.deportistas.model.DeporteModel;
import com.meli.deportistas.model.PersonaModel;
import com.meli.deportistas.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;
    private final DeporteService deporteService;

    // Constructor para inyección de dependencias (recomendado para servicios)
    public PersonaService(PersonaRepository personaRepository, DeporteService deporteService) {
        this.personaRepository = personaRepository;
        this.deporteService = deporteService;
    }

    public List<PersonaModel> getAllPersonas() {
        return personaRepository.personas;
    }

    public List<PersonaDto> getAllPersonasDto() {
        List<DeporteModel> allDeportes = deporteService.getAllDeportes();
        List<PersonaModel> allPersonas = personaRepository.personas;
        List<PersonaDto> allPersonasDto = new ArrayList<>();
        Random random = new Random();

        allPersonas.forEach(persona -> {
            // Selecciona un deporte al azar
            String nombreDeporte = "No existen deportes";
            if (!allDeportes.isEmpty()) {
                DeporteModel deporteAleatorio = allDeportes.get(random.nextInt(allDeportes.size()));
                nombreDeporte = deporteAleatorio.getNombre();
            }

            // Crear el DTO con toda la información
            PersonaDto personaDto = new PersonaDto(persona.getApellido(), persona.getEdad(), persona.getNombre(), nombreDeporte);
            allPersonasDto.add(personaDto);
        });

        return allPersonasDto;
    }
}