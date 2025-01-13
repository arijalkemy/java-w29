package com.bootcamp.controller;

import com.bootcamp.dto.PersonDto;
import com.bootcamp.model.Sport;
import com.bootcamp.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sport")
public class SportController {

    @Autowired
    private SportService sportService;

    @GetMapping("/")
    public ResponseEntity<List<Sport>> findSports() {
        List<Sport> sports = sportService.findSports();
        if (sports.isEmpty())
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        Optional<Sport> sport = sportService.findSportByName(name);
        if (sport.isEmpty())
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(sport.get().getLevel(), HttpStatus.OK);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<PersonDto>> findSportsPersons() {
        List<PersonDto> persons = sportService.findSportsPersons();
        if (persons.isEmpty())
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

}
