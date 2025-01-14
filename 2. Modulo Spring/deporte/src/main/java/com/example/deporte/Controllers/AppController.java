package com.example.deporte.Controllers;

import com.example.deporte.Models.Deporte;
import com.example.deporte.Models.PersonaDeporteDTO;
import com.example.deporte.Services.DeporteService;
import com.example.deporte.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    public class AppController {

    private final DeporteService deporteService;
    private final PersonaService personaService;

    @Autowired
    public AppController(DeporteService deporteService, PersonaService personaService) {
        this.deporteService = deporteService;
        this.personaService = personaService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getDeportes() {

        return ResponseEntity.ok(this.deporteService.findAll());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> getDeporte(@PathVariable String name) {
        return ResponseEntity.ok(this.deporteService.findByNombre(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> getDeportistas() {
        return ResponseEntity.ok(this.personaService.findAllPersonasDeportistas());
    }

}
