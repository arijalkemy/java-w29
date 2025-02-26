package com.sport.deportistas.controller;

import com.sport.deportistas.dto.DeporteDTO;
import com.sport.deportistas.dto.DeportistaDTO;
import com.sport.deportistas.service.DeportistasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {

    @Autowired
    private DeportistasServiceImpl deportistasService;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> getSports(){
        return new ResponseEntity<>(deportistasService.findSports(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDTO> getSportsByName(@PathVariable String name){
        return new ResponseEntity<>(deportistasService.findSportsByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> getSportsPersons(){
        return new ResponseEntity<>(deportistasService.findSportsPersons(), HttpStatus.OK);
    }
}
