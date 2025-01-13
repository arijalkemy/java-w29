package com.bootcamp.edad.controller;

import com.bootcamp.edad.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;


@RestController
public class EdadController {
    Map<Integer, Person> persons = new HashMap<>();
    @PostMapping("/person")
    public ResponseEntity<Integer> addPerson(@RequestBody Person person){
        int key = persons.size()+1;
        persons.put(key, person);
        return new ResponseEntity<>(key, HttpStatus.CREATED);
    }
    @GetMapping("/person")
    public ResponseEntity<Map<Integer, Person>> getPersons(){
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
    @GetMapping("/person/{id}")
    public ResponseEntity<Integer> getPersonAge(@PathVariable int id){
        Person person = persons.get(id);
        int age = calcularEdad(person.getBornDate());
        return new ResponseEntity<>(age, HttpStatus.OK);
    }
    public static int calcularEdad(LocalDate bornDate){
        LocalDate today = LocalDate.now();
        return Period.between(bornDate, today).getYears();
    }
}


