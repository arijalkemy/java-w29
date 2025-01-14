package com.meli.ej_starwars.service;

import com.meli.ej_starwars.dto.PersonajeDTO;


import java.util.List;

public interface PersonajeService {
    List<PersonajeDTO> findAllPersonajesByName(String name);
}
