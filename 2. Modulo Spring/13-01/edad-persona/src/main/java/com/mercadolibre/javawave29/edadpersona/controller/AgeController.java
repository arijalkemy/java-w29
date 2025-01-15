package com.mercadolibre.javawave29.edadpersona.controller;

import com.mercadolibre.javawave29.edadpersona.model.LifeTime;
import com.mercadolibre.javawave29.edadpersona.service.AgeService;
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

    @GetMapping("/getAge/{day}/{month}/{year}")
    public String getAge(@PathVariable("day") Integer day, @PathVariable("month") Integer month, @PathVariable("year") Integer year) {
        return ageService.getAge(day, month, year);
    }

    @PostMapping("/lifeTime")
    public ResponseEntity<LifeTime> addPerson(@RequestBody String date) {
        return ResponseEntity.ok(ageService.saveAge(date));
    }

    @GetMapping("/lifeTime/{id}")
    public ResponseEntity<LifeTime> getAgeById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(ageService.getAgeById(id));
    }
}
