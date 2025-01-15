package com.example.starWarsCharacters.controller;

import com.example.starWarsCharacters.dto.CharacterDto;
import com.example.starWarsCharacters.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDto>> getCharactersByName(@PathVariable String name) {
        return ResponseEntity.ok(characterService.getCharacterByName(name));
    }
}
