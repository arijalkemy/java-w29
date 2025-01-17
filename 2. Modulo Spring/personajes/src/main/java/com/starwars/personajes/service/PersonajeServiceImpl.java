package com.starwars.personajes.service;

import com.starwars.personajes.dto.response.PersonajeDTO;
import com.starwars.personajes.model.Personaje;
import com.starwars.personajes.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {
    private IPersonajeRepository repository;

    @Autowired
    public PersonajeServiceImpl(IPersonajeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PersonajeDTO> getPersonajesByName(String nombre) {
        List<Personaje> personajes = this.repository.getPersonajesByName(nombre);
        return personajes.stream().map(
                p -> new PersonajeDTO(
                        p.getName(),
                        p.getHeight(),
                        p.getMass(),
                        p.getGender(),
                        p.getHomeworld(),
                        p.getSpecies()
                )
        ).toList();
    }
}
