package org.bootcamp.dtoyresponseentityp2.controller;

import lombok.RequiredArgsConstructor;
import org.bootcamp.dtoyresponseentityp2.dto.DeportistaDTO;
import org.bootcamp.dtoyresponseentityp2.model.Deporte;
import org.bootcamp.dtoyresponseentityp2.service.DeporteService;
import org.bootcamp.dtoyresponseentityp2.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SportsController {

    private final DeporteService deporteService;

    private final PersonaService personaService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> sports() {
        return ResponseEntity.ok(deporteService.getDeportes());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Deporte> sportsByName(@PathVariable String name) {
        Optional<Deporte> optDeporteFound = deporteService.getDeporteByName(name);
        return optDeporteFound.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findSports/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        return ResponseEntity.ok(personaService.getPersonasDeportistas());
    }


}
