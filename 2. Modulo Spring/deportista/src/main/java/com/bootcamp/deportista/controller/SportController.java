package com.bootcamp.deportista.controller;

import com.bootcamp.deportista.domain.DeportistaDTO;
import com.bootcamp.deportista.domain.Person;
import com.bootcamp.deportista.domain.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class SportController {

    Sport basket = new Sport("basket", "hard");
    Sport football = new Sport("football", "medium");

    List<Sport> sportList = Arrays.asList(basket, football);

    Person person1 = new Person("SomePerson", "Healthy", 20);
    DeportistaDTO deportistaDTO1 = new DeportistaDTO(person1, basket);
    Person person2 = new Person("AnotherPerson", "Healthier", 26);
    DeportistaDTO deportistaDTO2 = new DeportistaDTO(person2, football);
    List<DeportistaDTO> deportistas = Arrays.asList(deportistaDTO1, deportistaDTO2);


    @GetMapping("/findSports")
    ResponseEntity<List<Sport>> getSports(){
        return new ResponseEntity<>(sportList, HttpStatus.OK);
    }
    @GetMapping("/findSport/{name}")
    ResponseEntity<String> getSportDifficulty(@PathVariable String name){
        Optional<Sport> sport = sportList.stream().filter(s -> s.getName().equals(name)).findFirst();
        return sport.map(value -> new ResponseEntity<>(value.getLevel(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/findSportsPerson")
    ResponseEntity<List<DeportistaDTO>> getDeportistas(){
        return new ResponseEntity<>(deportistas, HttpStatus.OK);
    }
}
