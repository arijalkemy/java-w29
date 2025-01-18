package com.spring_p1.sports.controller;

import com.spring_p1.sports.model.Sport;
import com.spring_p1.sports.service.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SportController {
    private final SportService sportService = new SportService();

    @GetMapping("/findSports")
    public ResponseEntity<String> findAllSports() {
        return new ResponseEntity<>(sportService.getSports().toString(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{sportId}")
    public ResponseEntity<String> findSports(@PathVariable int sportId) {
        Optional<Sport> foundSport = sportService.getSportById(sportId);
        return foundSport
                .map(sport -> new ResponseEntity<>("Sport is: " + sport + ".", HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No sport was found with that id.", HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<String> findSportsPersons() {
        return new ResponseEntity<>(sportService.getSportsPersons().toString(), HttpStatus.OK);
    }
}
