package com.meli.startwars.controller;

import com.meli.startwars.entity.Personaje;
import com.meli.startwars.service.IPersonajeService;
import com.meli.startwars.service.PersonajeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/star-wars")
public class PersonajeController {
    IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getPersonaje(@PathVariable String name) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.searchPersonajeByName(name));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
