package com.EjercicioEdadPersona.EdadPersona.Controller;
import com.EjercicioEdadPersona.EdadPersona.Model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EdadPersonaRestController {
    private List<Persona> personas = new ArrayList<>();
    private int currentId = 1;

    @GetMapping("/calcularedad/{nombre}")
    public String getEdad(@PathVariable String nombre,
                          @RequestParam int dia,
                          @RequestParam int mes,
                          @RequestParam int anio){

        LocalDate fNacimiento = LocalDate.of(anio,mes,dia);
        LocalDate fActual = LocalDate.now();

        Period edad = Period.between(fNacimiento,fActual);
        return "La edad de " + nombre + " es: " + edad.getYears() + " años.";
    }

    @GetMapping("/calcularedad")
    public String getEdad(@RequestParam int dia,
                          @RequestParam int mes,
                          @RequestParam int anio){
        LocalDate fNacimiento = LocalDate.of(anio,mes,dia);
        LocalDate fActual = LocalDate.now();

        Period edad = Period.between(fNacimiento,fActual);
        return "La edad es: " + edad.getYears() + " años.";
    }

    @PostMapping("/agregarPersona")
    public ResponseEntity<Persona> addPerson(@RequestBody Persona persona) {
        if (persona.getNombre() == null || persona.getDia() == null || persona.getMes() == null || persona.getAnio() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        persona.setId(currentId++);
        personas.add(persona);
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }

    @GetMapping("/getPersona/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Integer id) {
        Optional<Persona> personaOptional = personas.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        return personaOptional
                .map(persona -> new ResponseEntity<>(persona, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getPersonas")
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> responseList = new ArrayList<>();

        for (Persona persona : personas) {
            persona.setEdad(persona.calcularEdad());
            responseList.add(persona);
        }

        return new ResponseEntity<>(responseList, HttpStatus.OK);    }

}
