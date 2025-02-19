package com.example.obras_literarias.controller;

import com.example.obras_literarias.dto.ObraLiterariaRequestDto;
import com.example.obras_literarias.dto.ObraLiterariaResponseDto;
import com.example.obras_literarias.service.IObrasLiterariasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ObrasLiterariasController {
    private final IObrasLiterariasService service;

    @PostMapping("/obra-literaria")
    public ResponseEntity<ObraLiterariaResponseDto> createObraLiteraria(@RequestBody ObraLiterariaRequestDto request){
        var response = service.createObraLiteraria(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/obra-literaria")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getAllObraLiteraria(){
        var response = service.searchAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/obra-literaria/autor/{autor}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObraLiterariaByAutor(@PathVariable String autor){
        var response = service.searchByAutor(autor);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/obra-literaria/titulo/{titulo}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObraLiterariaByTitulo(@PathVariable String titulo){
        var response = service.searchByPalabarasClaveTitulo(titulo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/obra-literaria/year/{year}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObraLiterariaByYearBefore(@PathVariable Integer year){
        var response = service.searchBeforeYear(year);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/obra-literaria/editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObraLiterariaByEditorial(@PathVariable String editorial){
        var response = service.searchByEditorial(editorial);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
