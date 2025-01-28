package org.example.deportes.Controller;


import org.example.deportes.DTO.DeportistaDTO;
import org.example.deportes.Entity.Deporte;
import org.example.deportes.Services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private Services services;

    @GetMapping("/findSports")
    public List<Deporte> findSports() {
        // Llama al servicio para obtener todos los deportes
        return services.getSports();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSport(@PathVariable String name) {
        Deporte deporte = services.findSportByName(name);
        if (deporte != null) {
            return ResponseEntity.ok(deporte.getNivel()); // Aquí debe funcionar
        } else {
            return ResponseEntity.notFound().build(); // Maneja el caso en que no se encuentra el deporte
        }
    }

    @GetMapping("/findSportsPersons")
    public List<DeportistaDTO> findSportsPersons() {
        // Llama al servicio para obtener la lista de deportistas
        return services.getSportsPersons();
    }
}