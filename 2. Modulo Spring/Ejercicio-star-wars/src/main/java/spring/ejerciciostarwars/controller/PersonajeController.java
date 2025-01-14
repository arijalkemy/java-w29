package spring.ejerciciostarwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.ejerciciostarwars.dto.PersonajeDTO;
import spring.ejerciciostarwars.service.IPersonajeService;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {
    private final IPersonajeService service;

    @Autowired
    public PersonajeController(IPersonajeService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<PersonajeDTO>> getPersonajesByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(service.findByName(name));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
