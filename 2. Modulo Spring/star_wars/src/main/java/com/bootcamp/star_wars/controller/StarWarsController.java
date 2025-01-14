package com.bootcamp.star_wars.controller;

import com.bootcamp.star_wars.dto.response.CharacterDTO;
import com.bootcamp.star_wars.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/star-wars")
@RequiredArgsConstructor
public class StarWarsController {


    private final CharacterService characterService;

    @GetMapping("/character/{name}")
    public ResponseEntity<List<CharacterDTO>> getPersonaje(@PathVariable String name) {
        List<CharacterDTO> respuesta =  characterService.getPersonajesByName(name);
        return respuesta.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(respuesta);
    }
}
