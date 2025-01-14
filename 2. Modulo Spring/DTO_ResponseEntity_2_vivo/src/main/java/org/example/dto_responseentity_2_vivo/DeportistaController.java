package org.example.dto_responseentity_2_vivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeportistaController {

    private final DeportistaService deportistaService;

    @Autowired
    public DeportistaController(DeportistaService deportistaService) {
        this.deportistaService = deportistaService;
    }

    @GetMapping("/findSports")
    public List<Deporte> findAllSports() {
        return deportistaService.findAllSports();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        return deportistaService.findSportByName(name)
                .map(nivel -> ResponseEntity.ok(nivel.name()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deporte no encontrado"));
    }

    @GetMapping("/findSportsPersons")
    public List<DeportistaDeporteDTO> findSportsPersons() {
        return deportistaService.findSportsPersons();
    }
}
