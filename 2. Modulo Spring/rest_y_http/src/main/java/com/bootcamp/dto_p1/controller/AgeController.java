package com.bootcamp.dto_p1.controller;

import com.bootcamp.dto_p1.model.Person;
import com.bootcamp.dto_p1.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AgeController {

    private final AgeService ageService;

    @Autowired
    public AgeController(AgeService ageService) {
        this.ageService = ageService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> calculateAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        if (validDate(day, month, year)) {
            return ResponseEntity.ok(ageService.calculateAge(day, month, year));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        ageService.addPerson(person);
        return ResponseEntity.ok("Person created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Integer> getAgeById(@PathVariable int id){
        return ResponseEntity.ok(ageService.calculateAgeById(id));
    }

    private boolean validDate(int day, int month, int year) {
        return day > 0 && day <= 31 && month > 0 && month <= 12 && year > 0 && year <= 2025;
    }
}
