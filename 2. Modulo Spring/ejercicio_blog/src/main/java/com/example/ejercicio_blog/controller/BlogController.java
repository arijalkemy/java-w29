package com.example.ejercicio_blog.controller;

import com.example.ejercicio_blog.dto.EntradaBlogDto;
import com.example.ejercicio_blog.entity.EntradaBlog;
import com.example.ejercicio_blog.service.IBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/blogs")
public class BlogController {
    private final IBlogService blogService;

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDto> getBlogById(@PathVariable Integer id) {
        return new ResponseEntity<>(blogService.getBlogById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EntradaBlogDto>> getAllBlogs() {
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBlog(@RequestBody EntradaBlog entradaBlog) {
        return new ResponseEntity<>(blogService.createBlog(entradaBlog), HttpStatus.OK);
    }
}
