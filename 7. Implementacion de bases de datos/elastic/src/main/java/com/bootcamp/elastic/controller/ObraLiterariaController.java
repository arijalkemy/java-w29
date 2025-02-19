package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.model.ObraLiteraria;
import com.bootcamp.elastic.service.IObraLiterariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/obras")
public class ObraLiterariaController {
    private final IObraLiterariaService obraLiterariaService;
    @GetMapping("")
    public ResponseEntity<?> getObras() {
        return ResponseEntity.ok(obraLiterariaService.findAll());
    }
    @PostMapping("")
    public ResponseEntity<?> saveObra(@RequestBody ObraLiteraria obraLiteraria) {
        return new ResponseEntity<>(obraLiterariaService.save(obraLiteraria), HttpStatus.CREATED);
    }
    @GetMapping("/autor/{autor}")
    public ResponseEntity<?> getObrasByAutor(@PathVariable String autor) {
        return ResponseEntity.ok(obraLiterariaService.findByAutor(autor));
    }
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<?> getObrasByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(obraLiterariaService.findByTitulo(titulo));
    }
}
