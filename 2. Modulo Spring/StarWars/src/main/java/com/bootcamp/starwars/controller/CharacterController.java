package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/character/{name}")
    public ResponseEntity<?> getCharacter(@PathVariable String name) {
        return ResponseEntity.ok(characterService.findByName(name));
    }
}
