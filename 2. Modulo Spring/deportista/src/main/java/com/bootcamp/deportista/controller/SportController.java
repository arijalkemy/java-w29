package com.bootcamp.deportista.controller;

import com.bootcamp.deportista.dto.DeportistaDTO;
import com.bootcamp.deportista.domain.Sport;
import com.bootcamp.deportista.service.DeportistaService;
import com.bootcamp.deportista.service.PersonService;
import com.bootcamp.deportista.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SportController {

    @Autowired
    private SportService sportService;
    @Autowired
    private DeportistaService deportistaService;
    @GetMapping("/findSports")
    ResponseEntity<List<Sport>> getSports(){
        List<Sport> sports = sportService.getSports();
        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<String> getSportDifficulty(@PathVariable String name){
        Optional<Sport> sport = sportService.getSportByName(name);
        return sport.map(value -> new ResponseEntity<>(value.getLevel(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findSportsPerson")
    ResponseEntity<List<DeportistaDTO>> getDeportistas(){
        return new ResponseEntity<>(deportistaService.getDeportistas(), HttpStatus.OK);
    }
}
