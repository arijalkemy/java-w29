package spring.ejerciciostarwars.service;

import spring.ejerciciostarwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> findByName(String name);
}
