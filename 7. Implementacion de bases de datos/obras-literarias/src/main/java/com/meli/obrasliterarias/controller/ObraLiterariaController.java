package com.meli.obrasliterarias.controller;

import com.meli.obrasliterarias.dto.response.request.CreateObraDTO;
import com.meli.obrasliterarias.entity.ObraLiteraria;
import com.meli.obrasliterarias.service.IObraLiterariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obra")
@RequiredArgsConstructor
public class ObraLiterariaController {
    private final IObraLiterariaService service;

    @PostMapping
    public ResponseEntity<?> saveObra(@RequestBody ObraLiteraria o) {
        return new ResponseEntity<>(service.save(o), HttpStatus.CREATED);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<?> findByAutor(@PathVariable String autor) {
        return new ResponseEntity<>(service.findByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> findByTitulo(@PathVariable String nombre) {
        return new ResponseEntity<>(service.findByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/top5")
    public ResponseEntity<?> findTop5ByOrderByCantidadPaginasDesc() {
        return new ResponseEntity<>(service.findTop5ByOrderByCantidadPaginasDesc(), HttpStatus.OK);
    }

    @GetMapping("/anio/{anioPublicacion}")
    public ResponseEntity<?> findByAnioPublicacion(@PathVariable int anioPublicacion) {
        return new ResponseEntity<>(service.findByAnioPublicacion(anioPublicacion), HttpStatus.OK);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> findByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(service.findByEditorial(editorial), HttpStatus.OK);
    }
}
