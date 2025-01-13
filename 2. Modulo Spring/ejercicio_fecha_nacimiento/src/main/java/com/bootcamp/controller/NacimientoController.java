package com.bootcamp.controller;

import com.bootcamp.model.Persona;
import com.bootcamp.service.NacimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NacimientoController {

    @Autowired
    private NacimientoService nacimientoService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable Integer dia,
                               @PathVariable Integer mes,
                               @PathVariable Integer anio) {
        return nacimientoService.calcularEdad(dia, mes, anio);
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<String> getEdadById(@PathVariable Long id) {
        return ResponseEntity.ok().body(nacimientoService.getEdadById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona persona){
        return ResponseEntity.ok().body(nacimientoService.agregarPersona(persona));
    }

    
}
