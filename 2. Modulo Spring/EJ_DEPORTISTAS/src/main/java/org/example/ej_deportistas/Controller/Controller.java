package org.example.ej_deportistas.Controller;

import org.example.ej_deportistas.Dtos.DeportistaDto;
import org.example.ej_deportistas.Models.Deporte;
import org.example.ej_deportistas.Services.DeportesService;
import org.example.ej_deportistas.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private DeportesService deportes;
    @Autowired
    private PersonaService personas;


    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getAllDeportes() {

        return ResponseEntity.ok(deportes.getAllDeportes());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Deporte> findByName(@PathVariable String name) {

        return ResponseEntity.ok(deportes.getDeportebyName(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDto>> getAllDeportistas() {

        return ResponseEntity.ok(personas.getAllPersonas());
    }


}
