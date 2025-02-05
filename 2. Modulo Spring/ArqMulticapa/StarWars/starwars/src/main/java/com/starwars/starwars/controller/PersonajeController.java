package com.starwars.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.service.PersonajeService;



@RestController
@RequestMapping("/starwars")
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;
    @GetMapping("/personaje/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajesByName(@PathVariable String name) {
        List<PersonajeDTO> personajes = personajeService.getPersonajesByMatchInName(name);
        if (!personajes.isEmpty()) {
            return new ResponseEntity<List<PersonajeDTO>>(personajes, HttpStatus.OK);
        }  else {
            return new ResponseEntity<List<PersonajeDTO>>(HttpStatus.NO_CONTENT);
        }
    }
    
}
