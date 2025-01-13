package com.bootcamp.dto_p2.controller;

import com.bootcamp.dto_p2.dto.PersonDTO;
import com.bootcamp.dto_p2.model.Sport;
import com.bootcamp.dto_p2.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SportsController {

    private final SportService sportService;

    @Autowired
    public SportsController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> getSports() {
        return ResponseEntity.ok(sportService.getSports());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Sport> getSportByName(@PathVariable("name") String name) {
        Optional<Sport> sport = sportService.getSportByName(name);
        return sport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDTO>> getSportingPersons() {
        return ResponseEntity.ok(sportService.getSportingPersons());
    }
}
