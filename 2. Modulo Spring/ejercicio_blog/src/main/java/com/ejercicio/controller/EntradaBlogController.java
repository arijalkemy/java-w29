package com.ejercicio.controller;

import com.ejercicio.dto.BlogDto;
import com.ejercicio.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {

    @Autowired
    private IEntradaBlogService entradaBlogService;

    @PostMapping("/blog")
    public ResponseEntity<Long> addOne(@RequestBody BlogDto dto){
        return new ResponseEntity<>(entradaBlogService.addOne(dto), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> getBlogById(@PathVariable Long id){
        return new ResponseEntity<>(entradaBlogService.getBlogById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> findAllBlogs(){
        return new ResponseEntity<>(entradaBlogService.findAllBlogs(), HttpStatus.OK);
    }



}
