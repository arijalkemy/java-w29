package com.example.practiceSportsman.controller;

import com.example.practiceSportsman.dto.SportyPersonDTO;
import com.example.practiceSportsman.model.Person;
import com.example.practiceSportsman.model.Sport;
import com.example.practiceSportsman.service.PersonImp;
import com.example.practiceSportsman.service.SportImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SportsmanController {
    private PersonImp personImp = new PersonImp();
    private SportImp sportImp = new SportImp();
    private List<SportyPersonDTO> sportyPersonDTOList;

    public SportsmanController() {
        personImp.addPerson(new Person("Nomnbre1", "Apellido1", 20));
        personImp.addPerson(new Person("Nomnbre2", "Apellido2", 25));
        personImp.addPerson(new Person("Nomnbre3", "Apellido3", 30));
        sportImp.addSport(new Sport("Deporte1", "Basico"));
        sportImp.addSport(new Sport("Deporte2", "Intermedio"));
        sportImp.addSport(new Sport("Deporte3", "Avanzado"));
        sportyPersonDTOList = new ArrayList<>();
    }

    @GetMapping(path = ("findSports"))
    public ResponseEntity<?> findSports() {
        return new ResponseEntity<>(sportImp.getAllSports(), HttpStatus.OK);
    }

    @GetMapping(path = ("findSport/{name}"))
    public ResponseEntity<?> findSportByName(@PathVariable String name) {
        Sport sport = sportImp.getSportByName(name);
        if (sport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(sport, HttpStatus.OK);
        }
    }

    @GetMapping(path = ("findSportsPersons"))
    public ResponseEntity<?> findSportPerson() {
        List<Person> people = personImp.getAllPeople();
        List<Sport> sports = sportImp.getAllSports();
        for(int i = 0; i < people.size(); i++) {
            sportyPersonDTOList.add(new SportyPersonDTO(people.get(i).getName() + " " + people.get(i).getSurname(), sports.get(i).getName()));
        }

        return new ResponseEntity<>(sportyPersonDTOList, HttpStatus.OK);
    }

}
