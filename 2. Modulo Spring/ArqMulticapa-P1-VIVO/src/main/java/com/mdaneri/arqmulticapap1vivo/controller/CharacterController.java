package com.mdaneri.arqmulticapap1vivo.controller;

import com.mdaneri.arqmulticapap1vivo.dto.CharacterDTO;
import com.mdaneri.arqmulticapap1vivo.service.CharacterServiceImpl;
import com.mdaneri.arqmulticapap1vivo.service.ICharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    private final ICharacterService characterService;

    public CharacterController(ICharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CharacterDTO>> findByName(@RequestParam String substr) {
        return ResponseEntity.ok(characterService.findByName(substr));
    }

}
