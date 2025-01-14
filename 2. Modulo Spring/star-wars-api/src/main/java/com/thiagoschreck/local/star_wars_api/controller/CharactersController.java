package com.thiagoschreck.local.star_wars_api.controller;

import com.thiagoschreck.local.star_wars_api.dto.response.CharacterResponseDTO;
import com.thiagoschreck.local.star_wars_api.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/characters")
public class CharactersController {

    private final ICharacterService service;

    @Autowired
    public CharactersController(ICharacterService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CharacterResponseDTO>> getCharacters(@RequestParam(value = "name", required = false) String name) {
        return ResponseEntity.ok(service.getCharactersByName(name));
    }
}
