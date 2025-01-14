package org.bootcamp.arquitecturamulticapap1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.bootcamp.arquitecturamulticapap1.dto.PersonajeDTO;
import org.bootcamp.arquitecturamulticapap1.model.Personaje;
import org.bootcamp.arquitecturamulticapap1.repository.PersonajeRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements IPersonajeService{

    private final PersonajeRepositoryImpl personajeRepository;

    @Override
    public List<PersonajeDTO> getPersonajeByName(String name) {
        List<Personaje> personajesByName = personajeRepository.getPersonajeByName(name);
        ObjectMapper om = new ObjectMapper();
        return personajesByName.stream()
                .map(personaje -> om.convertValue(personaje, PersonajeDTO.class))
                .toList();
    }
}
