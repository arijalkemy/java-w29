package com.example.blog.controllers;

import com.example.blog.dto.EntradaBlogRequest;
import com.example.blog.entities.EntradaBlog;
import com.example.blog.services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService service;

    @PostMapping("/blog")
    public ResponseEntity<String> post(@RequestBody EntradaBlogRequest entradaBlogRequest) {
        EntradaBlog nuevo = service.save(entradaBlogRequest);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(nuevo.getId());
        return ResponseEntity.created(location).body(String.format("Blog creado correctamente -> ID: %s", nuevo.getId()));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlog> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlog>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
