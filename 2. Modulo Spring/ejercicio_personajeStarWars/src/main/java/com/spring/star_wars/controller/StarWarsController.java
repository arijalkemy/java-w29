package com.spring.star_wars.controller;

import com.spring.star_wars.dto.SWCharacterDTO;
import com.spring.star_wars.service.StarWarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starWars/characters")
public class StarWarsController {
    @Autowired
    StarWarsServiceImpl starWarsService;

    @GetMapping("/{partialName}")
    public ResponseEntity<List<SWCharacterDTO>> getCharacters(@PathVariable String partialName) {
        return ResponseEntity.ok(starWarsService.findCharactersNamed(partialName));
    }
}
