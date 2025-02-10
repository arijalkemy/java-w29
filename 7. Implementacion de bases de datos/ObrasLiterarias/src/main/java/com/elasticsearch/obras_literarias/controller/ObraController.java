package com.elasticsearch.obras_literarias.controller;

import com.elasticsearch.obras_literarias.model.Obra;
import com.elasticsearch.obras_literarias.service.ObraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("obras")
@RequiredArgsConstructor
public class ObraController {

    private final ObraService obraService;

    @PostMapping
    public ResponseEntity<Obra> save(@RequestBody Obra obra) {
        return ResponseEntity.ok(obraService.save(obra));
    }

    @GetMapping
    public ResponseEntity<Iterable<Obra>> getAll() {
        return ResponseEntity.ok(obraService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obra> getById(@PathVariable String id) {
        return ResponseEntity.ok(obraService.getById(id));
    }

    @GetMapping("/autor/{nombre}")
    public ResponseEntity<Iterable<Obra>> getByAutor(@PathVariable String nombre) {
        return ResponseEntity.ok(obraService.getByAutor(nombre));
    }

    @GetMapping("/titulo/{palabra}")
    public ResponseEntity<Iterable<Obra>> getByTitulo(@PathVariable String palabra) {
        return ResponseEntity.ok(obraService.getAllByTitulo(palabra));
    }

    @GetMapping("/top-pages")
    public ResponseEntity<Iterable<Obra>> getTopPages() {
        return ResponseEntity.ok(obraService.getTopPages());
    }

    @GetMapping("/antes-de/{anio}")
    public ResponseEntity<Iterable<Obra>> getObrasAntesDe(@PathVariable Integer anio) {
        return ResponseEntity.ok(obraService.getObrasAntesDe(anio));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<Iterable<Obra>> getByEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(obraService.getByEditorial(editorial));
    }
}
