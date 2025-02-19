package com.bootcamp.hql.controller;

import com.bootcamp.hql.dto.SiniestroDto;
import com.bootcamp.hql.dto.VehiculoDto;
import com.bootcamp.hql.service.ISiniestroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SiniestroController {
    private final ISiniestroService siniestroService;

    public SiniestroController(ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping("/siniestro")
    public ResponseEntity<?> createSiniestro(@RequestBody SiniestroDto siniestroDto) {
        SiniestroDto newSiniestro = siniestroService.createSiniestro(siniestroDto);
        return new ResponseEntity<>(newSiniestro, HttpStatus.CREATED);
    }
    @GetMapping("/siniestro/{id}")
    public ResponseEntity<?> getSiniestro(@PathVariable Long id) {
        SiniestroDto siniestro = siniestroService.getSiniestro(id);
        return new ResponseEntity<>(siniestro, HttpStatus.OK);
    }
    @GetMapping("/siniestro/loses")
    public ResponseEntity<?> findSiniestrosWithLosesGraterThan(@RequestParam(required = false) int loses) {
        List<VehiculoDto> vehiculos = siniestroService.findByLosesGraterThan(loses);
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    @GetMapping("/siniestro/loses/total")
    public ResponseEntity<?> findTotalLosesGraterThan(@RequestParam(required = false) int loses) {
        Long totalLoses = siniestroService.findTotalLosesGraterThan(loses);
        return new ResponseEntity<>(totalLoses, HttpStatus.OK);
    }

}
