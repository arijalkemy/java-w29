package com.StarWars.starwars.controller;


import com.StarWars.starwars.service.IStarWarsService;
import com.StarWars.starwars.service.StarWarServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarWarsController {
    private IStarWarsService starWarService;

    public StarWarsController(StarWarServiceImpl starWarService){
        this.starWarService = starWarService;
    }

    @GetMapping("/character/{name}")
    public ResponseEntity<?> getCharacter(@PathVariable String name){
        return new ResponseEntity<>(starWarService.searchCharacter(name), HttpStatus.OK);
    }
}
