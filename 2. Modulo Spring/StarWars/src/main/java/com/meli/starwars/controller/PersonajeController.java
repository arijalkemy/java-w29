package com.meli.starwars.controller;

import com.meli.starwars.dto.response.PersonajeResponseDTO;
import com.meli.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/personajes")
public class PersonajeController {

    private IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeResponseDTO>> getPersonajesByName(@PathVariable String name) {
        return ResponseEntity.ok(this.personajeService.searchByName(name));
    }

}
