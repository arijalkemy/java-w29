package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.entity.Character;
import com.bootcamp.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/characters")
    public ResponseEntity<List<CharacterDTO>> getCharacters(){
        List<CharacterDTO> characters = characterService.getAllCharacters();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @GetMapping("/characters/{name}")
    public ResponseEntity<List<CharacterDTO>> getCharacter(@PathVariable String name){
        List<CharacterDTO> charactersDTO = characterService.getCharacterByName(name);
        return new ResponseEntity<>(charactersDTO, HttpStatus.OK);
    }
}
