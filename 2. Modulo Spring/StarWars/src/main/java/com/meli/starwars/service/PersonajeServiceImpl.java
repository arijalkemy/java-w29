package com.meli.starwars.service;

import com.meli.starwars.dto.response.PersonajeResponseDTO;
import com.meli.starwars.model.Personaje;
import com.meli.starwars.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    private final IPersonajeRepository personajeRepository;

    public PersonajeServiceImpl(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public List<PersonajeResponseDTO> searchByName(String name) {
        List<Personaje> personajes = this.personajeRepository.searchByName(name);

         return personajes.stream().map(
                 p -> new PersonajeResponseDTO(
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
