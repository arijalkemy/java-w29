package com.thiagoschreck.local.detectando_deportistas.controller;

import com.thiagoschreck.local.detectando_deportistas.dto.DeporteDTO;
import com.thiagoschreck.local.detectando_deportistas.dto.PersonaDTO;
import com.thiagoschreck.local.detectando_deportistas.service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class SportsController {

    @Autowired
    private SportsService sportsService;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> getAllSports() {
        return ResponseEntity.ok(sportsService.getAllSports());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<List<DeporteDTO>> getSportByName(@PathVariable String name) {
        return ResponseEntity.ok(sportsService.getSportByName(name));
    }

    @GetMapping("/findSportPersons")
    public ResponseEntity<List<PersonaDTO>> getSportsPersons() {
        return ResponseEntity.ok(sportsService.getAllSportsPersons());
    }
}
