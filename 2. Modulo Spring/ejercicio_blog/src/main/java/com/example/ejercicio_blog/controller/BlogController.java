package com.example.ejercicio_blog.controller;

import com.example.ejercicio_blog.dto.EntradaBlogDto;
import com.example.ejercicio_blog.dto.response.NuevaEntradaBlogDto;
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
        return ResponseEntity.status(HttpStatus.OK).body(blogService.getBlogById(id));
    }

    @GetMapping
    public ResponseEntity<List<EntradaBlogDto>> getAllBlogs() {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.getAll());
    }

    @PostMapping
    public ResponseEntity<NuevaEntradaBlogDto> createBlog(@RequestBody EntradaBlogDto entradaBlogDto) {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.createBlog(entradaBlogDto));
    }
}
