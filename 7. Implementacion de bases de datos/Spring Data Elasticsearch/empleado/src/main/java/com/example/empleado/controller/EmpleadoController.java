package com.example.empleado.controller;

import com.example.empleado.model.Empleado;
import com.example.empleado.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empleado")
public class EmpleadoController {

    private final EmpleadoService service;

    @GetMapping
    public ResponseEntity<Iterable<Empleado>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado) {
        return ResponseEntity.ok(service.save(empleado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> update(
            @RequestBody Empleado empleado,
            @PathVariable String id) {
        return ResponseEntity.ok(service.update(id, empleado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }
}