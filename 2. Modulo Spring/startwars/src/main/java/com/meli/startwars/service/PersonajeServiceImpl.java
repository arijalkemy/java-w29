package com.meli.startwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.startwars.dto.PersonajeDtoResponse;
import com.meli.startwars.entity.Personaje;
import com.meli.startwars.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    IPersonajeRepository personajeRepoImpl;
    ObjectMapper mapper = new ObjectMapper();

    public PersonajeServiceImpl(IPersonajeRepository personajeRepoImpl) {
        this.personajeRepoImpl = personajeRepoImpl;
    }

    @Override
    public List<PersonajeDtoResponse> searchPersonajeByName(String name) throws Exception {
        List<Personaje> personajes = personajeRepoImpl.fiendByName(name);
        if(personajes.isEmpty()){
            throw new Exception("No hay personajes que coinscidan con el nombre");
        }
        return personajes.stream()
                .map(p -> new PersonajeDtoResponse(
                        p.getName(),
                        p.getHeight(),
                        p.getMass(),
                        p.getGender(),
                        p.getHomeWorld(),
                        p.getSpecies()
                ))
                .collect(Collectors.toList());
    }
}
