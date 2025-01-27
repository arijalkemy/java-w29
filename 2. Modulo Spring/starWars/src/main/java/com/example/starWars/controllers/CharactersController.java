package com.example.starWars.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import com.example.starWars.dtos.responseCharacterDto;
import com.example.starWars.services.FindCharacters;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CharactersController {
    private final FindCharacters findCharacters;

    @GetMapping("/characters")
    public ResponseEntity<?> getCharacters(@RequestParam("name") String name){
        ObjectMapper objectMapper = new ObjectMapper();
        List<responseCharacterDto> responseList = objectMapper
                .convertValue(findCharacters.findByName(name), new TypeReference<List<responseCharacterDto>>(){});
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

}
