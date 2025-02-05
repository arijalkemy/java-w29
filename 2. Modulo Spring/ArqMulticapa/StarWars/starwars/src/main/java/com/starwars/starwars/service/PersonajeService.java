package com.starwars.starwars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.repository.IPersonajeRepository;

@Service
public class PersonajeService {

    @Autowired
    IPersonajeRepository personajeRepository;
    public List<PersonajeDTO> getPersonajesByMatchInName(String name) {
        List<PersonajeDTO> result = new ArrayList<PersonajeDTO>();
        personajeRepository.getAllPersonajes()
                            .stream()
                            .filter(c -> c.getName().
                                        toUpperCase().
                                        contains(name.toUpperCase()))
                            .map(c -> new PersonajeDTO(c.getName(),
                                                        c.getHeight(),
                                                        c.getMass(),
                                                        c.getGender(),
                                                        c.getHomeworld(),
                                                        c.getSpecies()))
                            .forEach(c -> result.add(c));
        return result;
    }
}
