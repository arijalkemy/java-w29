package com.bootcamp.obrasliterarias.controller;

import com.bootcamp.obrasliterarias.service.ObraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("obra")
@RequiredArgsConstructor
public class ObraController {
    private final ObraService obraService;

    @GetMapping("autor/{nombreAutor}")
    public ResponseEntity<?> obtenerObrasPorAutor(@PathVariable("nombreAutor") String nombreAutor) {
        return ResponseEntity.ok(obraService.buscarObrasPorAutor(nombreAutor));
    }

    @GetMapping
    public ResponseEntity<?> obtenerObrasPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(obraService.buscarObrasPorTitulo(titulo));
    }

    @GetMapping("top5")
    public ResponseEntity<?> obtenerTop5() {
        return ResponseEntity.ok(obraService.buscarTop5());
    }
}
