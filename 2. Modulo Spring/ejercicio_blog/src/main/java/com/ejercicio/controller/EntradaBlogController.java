package com.ejercicio.controller;

import com.ejercicio.dto.BlogDto;
import com.ejercicio.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntradaBlogController {

    @Autowired
    private IEntradaBlogService entradaBlogService;

    @PostMapping("/blog")
    public ResponseEntity<?> addOne(@RequestBody BlogDto dto){
        return new ResponseEntity<>("Blog creado correctamente con el ID: " +entradaBlogService.addOne(dto), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Long id){
        return new ResponseEntity<>(entradaBlogService.getBlogById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllBlogs")
    public ResponseEntity<?> getAllBlogs(){
        return new ResponseEntity<>(entradaBlogService.getAllBlogs(), HttpStatus.OK);
    }



}
