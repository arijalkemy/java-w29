package com.example.demo.service;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.repository.PersonajeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonajeService implements IPersonajeService {
    private final PersonajeRepository personajeRepository;

    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> obtenerPersonajes(String valor) {
        return personajeRepository.encontrarPersonajes()
                .stream()
                .map(PersonajeDTO::convertirDTO)
                .filter(p-> p.contieneValor(valor))
                .toList();
    }
}
