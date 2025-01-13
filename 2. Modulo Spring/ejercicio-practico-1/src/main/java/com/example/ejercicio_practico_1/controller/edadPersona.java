package com.example.ejercicio_practico_1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class edadPersona {
    List<Persona> personas = new ArrayList<>();

    @GetMapping("/{dia}/{mes}/{anio}")
    public int edadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        //Obtengo la fecha actual
        LocalDate fechaActual = LocalDate.now();
        String fechaComoString = fechaActual.toString();

        //Paso a array y luego paso a int
        String[] arrFechaActual = fechaComoString.split("-");
        int anioActual = Integer.parseInt(arrFechaActual[0]);
        int mesActual = Integer.parseInt(arrFechaActual[1]);
        int diaActual = Integer.parseInt(arrFechaActual[2]);

        int edad = 0;

        if(mes <= mesActual) { //Mismo mes o mes anterior
            if(dia <= diaActual) { //Cumple antes que la fecha actual
                edad = anioActual - anio;
            }else { //Dia a futuro mismo mes
                edad = anioActual - anio - 1;
                System.out.println("entre aca");
            }
        }else { //Futuro
            edad = anioActual - anio - 1;
        }
        return edad;
    }

    @PostMapping("/agregarPersona")
    public ResponseEntity<String> agregarPersona(@RequestBody Persona persona){
        personas.add(persona);
        return new ResponseEntity<>("Persona agregada exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/obtenerEdad")
    public Integer obtenerEdad(@RequestParam Integer id){
        for(Persona persona : personas){
            if(persona.getId() == id){
                return persona.getEdad();
            }
        }
        return null;
    }
}
