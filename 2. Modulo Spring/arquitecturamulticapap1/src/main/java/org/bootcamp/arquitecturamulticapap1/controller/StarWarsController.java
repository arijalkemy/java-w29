package org.bootcamp.arquitecturamulticapap1.controller;

import lombok.RequiredArgsConstructor;
import org.bootcamp.arquitecturamulticapap1.dto.PersonajeDTO;
import org.bootcamp.arquitecturamulticapap1.service.IPersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/starwars")
public class StarWarsController {

    private final IPersonajeService personajeService;

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> findByName(@PathVariable String name) {
        List<PersonajeDTO> personajesDTO = personajeService.getPersonajeByName(name);
        if (personajesDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(personajesDTO, HttpStatus.OK);
    }
}
