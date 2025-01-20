package org.example.starwars_ejercicio.controllers;

import org.example.starwars_ejercicio.services.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/character")
@RestController
public class CharacterController {

    @Autowired
    private ICharacterService iCharacterService;

    @GetMapping()
    public ResponseEntity<?> getCharacters(){
        return new ResponseEntity<>(iCharacterService.getCharacters(), HttpStatus.OK);
    }

    @GetMapping("/findWord")
    public ResponseEntity<?> getCharactersForWord(@RequestParam String word){
        return new ResponseEntity<>(iCharacterService.getCharactersForWord(word), HttpStatus.OK);
    }
}
