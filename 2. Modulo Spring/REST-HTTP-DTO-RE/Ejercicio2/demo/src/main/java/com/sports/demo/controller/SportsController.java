package com.sports.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sports.demo.DTOs.PersonDTO;
import com.sports.demo.model.Person;
import com.sports.demo.model.Sport;
import com.sports.demo.service.PersonService;
import com.sports.demo.service.SportService;





@RestController
@RequestMapping("/api/sports/")
public class SportsController {

    PersonService personService = new PersonService();
    SportService sportService = new SportService();
    @GetMapping("findSports")
    public ResponseEntity<List<Sport>> getAllSports() {
        List<Sport> sports = sportService.getAllSports();
        return new ResponseEntity<List<Sport>>(sports,HttpStatus.OK);
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<Sport> getSport(@PathVariable String name) {
        Sport sport = sportService.getSportByName(name);
        if (sport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Sport>(sport,HttpStatus.OK);
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<PersonDTO>> getSportPeople(String param) {
        List<PersonDTO> people = personService.getAllPeople();
        return new ResponseEntity<List<PersonDTO>>(people,HttpStatus.OK);
    }

    @PostMapping("addPerson")
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        personService.add(person);
        return new ResponseEntity<>("SE HA CREADO CORRECTAMENTE",HttpStatus.OK);
    }
    
    
    
    
}
