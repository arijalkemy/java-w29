package com.elasticsearch.ej_empleados.controller;

import com.elasticsearch.ej_empleados.dto.EmpleadoDto;
import com.elasticsearch.ej_empleados.model.Empleado;
import com.elasticsearch.ej_empleados.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empleados")
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
