package com.example.demo.controller;

import com.example.demo.model.Deporte;
import com.example.demo.model.Persona;
import com.example.demo.service.DeporteService;
import com.example.demo.service.DeporteServiceImp;
import com.example.demo.service.DeportistaDTOService;
import com.example.demo.service.DeportistaDTOServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("deporte")
public class DeporteController {
    private final DeporteServiceImp deporteServiceImp;
    private final DeportistaDTOServiceImpl deportistaDTOServiceImpl;
    private final DeportistaDTOService deportistaDTOService;

    public DeporteController(DeporteServiceImp deporteServiceImp, DeportistaDTOServiceImpl deportistaDTOServiceImpl, DeportistaDTOService deportistaDTOService) {
        this.deporteServiceImp = deporteServiceImp;
        this.deportistaDTOServiceImpl = deportistaDTOServiceImpl;
        this.deportistaDTOService = deportistaDTOService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<String> findSports() {
        return ResponseEntity.ok("Los deportes registrados son: " +deporteServiceImp.verDeportes());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        return ResponseEntity.ok("El deporte es: " +deporteServiceImp.buscarPorNombre(name));
    }

    @PostMapping("/createSport")
    public ResponseEntity<?> createSport(@RequestBody Deporte deporte) {
        deporteServiceImp.saveDeporte(deporte);
        System.out.println("deporte: " + deporte);
        return  ResponseEntity.ok(deporte);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportPerson(){
        return ResponseEntity.ok(deportistaDTOServiceImpl.findAll());
    }

    @PostMapping("/createPerson")
    public ResponseEntity<?> createPerson(@RequestBody Persona p) {
        deporteServiceImp.saveDeporte(p.getDeporte());
        deportistaDTOService.addPersona(p);
        return ResponseEntity.ok(p);
    }


}
