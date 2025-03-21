package com.bootcamp.siniestros.controller;

import com.bootcamp.siniestros.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vehiculos")
@RequiredArgsConstructor
public class VehiculoController {
    private final VehiculoService vehiculoService;

    @GetMapping("patentes")
    public ResponseEntity<?> getAllByPatentes() {
        return ResponseEntity.ok(vehiculoService.findAllPatentes());
    }

    @GetMapping("patentes/fecha-marca")
    public ResponseEntity<?> getAllPatenteByFechaAndMarca() {
        return ResponseEntity.ok(vehiculoService.findPatentesSortByFecha());
    }

    @GetMapping("patentes/{cantidadRuedas}/{anio}")
    public ResponseEntity<?> getPatentesByCantidadRuedasYAnio
            (@PathVariable Integer cantidadRuedas, @PathVariable Integer anio) {
        return ResponseEntity.ok(vehiculoService.findPatentesByCantidadRuedasYAnio(cantidadRuedas, anio));
    }

    @GetMapping("siniestro")
    public ResponseEntity<?> getAllBySiniestro() {
        return ResponseEntity.ok(vehiculoService.findBySiniestro(40000));
    }
}
