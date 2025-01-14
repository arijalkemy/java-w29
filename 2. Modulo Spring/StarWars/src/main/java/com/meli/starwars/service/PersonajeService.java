package com.meli.starwars.service;

import com.meli.starwars.dto.PersonajeDTO;
import com.meli.starwars.model.Personaje;
import com.meli.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {

    private final PersonajeRepository personajeRepository;

    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public List<PersonajeDTO> searchByName(String name) {
        List<Personaje> personajes = this.personajeRepository.searchByName(name);

         return personajes.stream().map(
                 p -> new PersonajeDTO(
                    p.getName(),
                    p.getHeight(),
                    p.getMass(),
                    p.getGender(),
                    p.getHomeWorld(),
                    p.getSpecies()
                )
         ).toList();
    }

}
