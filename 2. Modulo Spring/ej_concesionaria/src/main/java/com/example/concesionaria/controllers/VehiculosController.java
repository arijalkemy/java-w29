package com.example.concesionaria.controllers;

import com.example.concesionaria.entities.Vehiculo;
import com.example.concesionaria.services.VehiculosService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
@RequiredArgsConstructor
public class VehiculosController {

    private final VehiculosService service;

    @PostMapping
    public ResponseEntity<Vehiculo> addVehicle(@RequestBody Vehiculo vehiculo) {
        Vehiculo nuevo = service.add(vehiculo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(nuevo.getId());
        return ResponseEntity.created(location).body(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<Vehiculo>> getByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to) {
        return ResponseEntity.ok(service.getByDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<Vehiculo>> getByPrice(
            @RequestParam Integer since,
            @RequestParam Integer to) {
        return ResponseEntity.ok(service.getByPrice(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

}
