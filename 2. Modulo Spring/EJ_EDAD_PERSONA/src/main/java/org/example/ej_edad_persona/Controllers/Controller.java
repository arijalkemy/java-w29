package org.example.ej_edad_persona.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.ej_edad_persona.Dtos.FechaNacimientoDto;
import org.example.ej_edad_persona.Entities.Persona;
import org.example.ej_edad_persona.Services.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persona")
public class Controller {


    private final PersonaService service;

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> obtenerEdad(
            @PathVariable Integer dia,
            @PathVariable Integer mes,
            @PathVariable Integer anio

    )
    {
        return ResponseEntity.ok(service.calcularEdad(dia, mes, anio));
    }

    @PostMapping
    public ResponseEntity<String> crearPersona(@RequestBody FechaNacimientoDto fechaNacimiento) {

        Persona persona = service.addPersona(fechaNacimiento);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(persona.getId());
        return ResponseEntity.created(location).body("Persona creada correctamente. ID: " + persona.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> obtenerPersona(@PathVariable Long id) {
        return  ResponseEntity.ok(String.format("Edad: %s", service.getEdad(id)));
    }


}
