package com.example.blog.controller;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.service.BlogServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BlogController {
    private final BlogServiceImpl blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> crearEntradaBlog(@RequestBody EntradaBlogDto blog) {
        return ResponseEntity.ok(blogService.crearEntradaBlog(blog));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDto> getEntradaBlog(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getEntradaBlog(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<Iterable<EntradaBlogDto>> getAllEntradasBlog() {
        return ResponseEntity.ok(blogService.getAllEntradasBlog());
    }
}
