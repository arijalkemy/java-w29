package com.mercadolibre.javawave29.star_wars.controller;

import com.mercadolibre.javawave29.star_wars.dto.CharacterDTO;
import com.mercadolibre.javawave29.star_wars.model.StarWarsCharacter;
import com.mercadolibre.javawave29.star_wars.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/characters")
@RestController
public class StarWarsController {

    private final IService service;

    @Autowired
    public StarWarsController (IService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getCharacters() {
        return service.getCharacters();
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> getCharactersByName(@PathVariable String name) { return service.getCharactersByName(name); }

    //ADICIONAL
    @PostMapping
    public ResponseEntity<CharacterDTO> addCharacter (@RequestBody StarWarsCharacter character) { return service.addCharacter(character); }
}
