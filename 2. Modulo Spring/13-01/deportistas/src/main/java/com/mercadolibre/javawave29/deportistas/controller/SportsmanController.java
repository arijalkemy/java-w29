package com.mercadolibre.javawave29.deportistas.controller;

import com.mercadolibre.javawave29.deportistas.model.Sport;
import com.mercadolibre.javawave29.deportistas.model.SportsPersonsDTO;
import com.mercadolibre.javawave29.deportistas.service.IService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SportsmanController {

    private final IService service;

    public SportsmanController(IService service) {
        this.service = service;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findSports() {
        List<Sport> sports = service.findAll();
        if (sports.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(sports);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Sport> finSport(@PathVariable String name) {
        Sport sport = service.findByName(name);
        if (sport == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(sport);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportsPersonsDTO>> findSportsPersons() {
        List<SportsPersonsDTO> sportsPersons = service.findSportsPersons();
        if (sportsPersons.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(sportsPersons);
    }
}
