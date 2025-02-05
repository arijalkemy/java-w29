package com.org.meli.starwars.controller;

import com.org.meli.starwars.dto.CharacterDto;
import com.org.meli.starwars.service.IServiceCharacter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    private final IServiceCharacter serviceCharacter;

    public CharacterController(IServiceCharacter serviceCharacter) {
        this.serviceCharacter = serviceCharacter;
    }

    @GetMapping("/findCharacter")
    public ResponseEntity<List<CharacterDto>> getCharactersByName(@RequestParam String name) {
        return new ResponseEntity<>(serviceCharacter.findCharacterByName(name), HttpStatus.OK);
    }
}
