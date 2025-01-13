package com.example.deportistas.controller;

import com.example.deportistas.DTO.PersonSportDTO;
import com.example.deportistas.model.Sport;
import com.example.deportistas.service.PersonService;
import com.example.deportistas.service.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportsController {
    private SportService sportService = new SportService();
    private PersonService personService = new PersonService();

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findSports() {
        return new ResponseEntity<List<Sport>>(sportService.getSportList(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Sport> findSportByName(@PathVariable String name) {
        return new ResponseEntity<Sport>(sportService.findSport(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonSportDTO>> findSportsPersons(){

            return new ResponseEntity<List<PersonSportDTO>>(personService.getPersonSports(), HttpStatus.OK);



    }
}
