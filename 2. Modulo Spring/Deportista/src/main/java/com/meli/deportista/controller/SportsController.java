package com.meli.deportista.controller;

import com.meli.deportista.DTO.SportsPersonDTO;
import com.meli.deportista.model.Person;
import com.meli.deportista.model.Sport;
import com.meli.deportista.service.PersonService;
import com.meli.deportista.service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController("/sports")
public class SportsController {

    private final SportsService sportsService;
    private final PersonService personService;

    @Autowired
    public SportsController(
            SportsService sportsService,
            PersonService personService
    ) {
        this.sportsService = sportsService;
        this.personService = personService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> index() {
        return ResponseEntity.ok(this.sportsService.getSports());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Sport> findSport(@PathVariable String name) {
        Optional<Sport> sport = this.sportsService.getSportByName(name);
        if (sport.isPresent()) {
            return ResponseEntity.ok(sport.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportsPersonDTO>> findSportsPersons() {
        List<Person> persons = this.personService.getPersons();

        List<SportsPersonDTO> sportsPersonDTOS = new ArrayList<>();
        for (Person person : persons) {
            sportsPersonDTOS.add(
                    new SportsPersonDTO(
                            person.getFirstName(),
                            person.getLastName(),
                            person.getSport().getName()
                    )
            );
        }

        return ResponseEntity.ok(sportsPersonDTOS);
    }
}
