package com.bootcamp.youtuber.controller;

import com.bootcamp.youtuber.dto.EntradaBlogDTO;
import com.bootcamp.youtuber.service.EntradaBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EntradaBlogController {

    private final EntradaBlogService entradaBlogService;

    @PostMapping("/blog")
    public ResponseEntity<?> addBlog(@RequestBody EntradaBlogDTO entradaBlogDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entradaBlogService.addBlog(entradaBlogDTO));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable int id) {
        return ResponseEntity.ok(entradaBlogService.getById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogs() {
        return ResponseEntity.ok(entradaBlogService.getAll());
    }

}
