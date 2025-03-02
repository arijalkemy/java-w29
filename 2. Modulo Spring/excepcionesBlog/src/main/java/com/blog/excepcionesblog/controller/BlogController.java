package com.blog.excepcionesblog.controller;

import com.blog.excepcionesblog.dto.EntradaBlogDTO;
import com.blog.excepcionesblog.service.BlogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogServiceImpl blogService;

    @PostMapping
    public ResponseEntity<String> crearEntrada(@RequestBody EntradaBlogDTO entradaBlogDTO) {
        return new ResponseEntity<>(blogService.crearEntrada(entradaBlogDTO), HttpStatus.CREATED);
    }

    /*@PostMapping
    public String crearEntrada(@RequestBody EntradaBlogDTO entradaBlogDTO) {
        return blogService.crearEntrada(entradaBlogDTO);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDTO> obtenerEntradaPorId(@PathVariable Integer id) {
        return new ResponseEntity<>(blogService.obtenerEntradaPorId(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<Map<Integer, EntradaBlogDTO>> obtenerTodasLasEntradas() {
        return new ResponseEntity<>(blogService.obtenerTodasLasEntradas(), HttpStatus.OK);
    }


















}
