package org.bootcamp.arquitecturamulticapap1.service;

import org.bootcamp.arquitecturamulticapap1.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> getPersonajeByName(String name);
}
