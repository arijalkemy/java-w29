package com.mdaneri.dtoresponseentityvivo.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static java.time.temporal.ChronoUnit.YEARS;

@RestController
public class AgeController {

    private Map<Long, LocalDate> birthdates;

    public AgeController() {
        this.birthdates = new HashMap<>();
    }

    @GetMapping(path = "{day}/{month}/{year}")
    public Long handler(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        return YEARS.between(LocalDate.of(year, month, day), LocalDate.now());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        LocalDate savedLD = birthdates.get(id);
        if (savedLD == null)
            return new ResponseEntity<>("ID not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(YEARS.between(savedLD, LocalDate.now()), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> saveBirthdate(@PathVariable Long id, @RequestBody
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthdate) {
        birthdates.put(id, birthdate);
        return new ResponseEntity<>("Birthdate added.", HttpStatus.CREATED);
    }

}
