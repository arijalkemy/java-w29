package com.example.obras_literarias.controller;

import com.example.obras_literarias.dto.ObraLiterariaRequestDto;
import com.example.obras_literarias.dto.ObraLiterariaResponseDto;

import com.example.obras_literarias.service.ObrasLiterariasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ObrasLiterariasController {
    @Autowired
    private  ObrasLiterariasService service;

    @PostMapping("/obra-literaria")
    public ResponseEntity<ObraLiterariaResponseDto> createObraLiteraria(@RequestBody ObraLiterariaRequestDto request){
        var response = service.createObraLiteraria(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/obra-literaria")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getAllObraLiteraria() {
        List<ObraLiterariaResponseDto> response = service.searchAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint para obtener obras literarias por autor
    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObrasByAutor(@PathVariable String autor) {
        List<ObraLiterariaResponseDto> response = service.getObrasByAutor(autor);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint para obtener obras literarias por título (busqueda de palabras clave)
    @GetMapping("/titulo/{keyword}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObrasByTitulo(@PathVariable String keyword) {
        List<ObraLiterariaResponseDto> response = service.getObrasByTitulo(keyword);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint para obtener las 5 obras literarias con más páginas
    @GetMapping("/top5")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getTop5ObrasPorPaginas() {
        List<ObraLiterariaResponseDto> response = service.getTop5ObrasPorPaginas();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint para obtener obras literarias antes de un año específico
    @GetMapping("/antes-del-ano/{year}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObrasAntesDelAno(@PathVariable int year) {
        List<ObraLiterariaResponseDto> response = service.getObrasAntesDelAno(year);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint para obtener obras literarias por editorial
    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObrasPorEditorial(@PathVariable String editorial) {
        List<ObraLiterariaResponseDto> response = service.getObrasPorEditorial(editorial);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
