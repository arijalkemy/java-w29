package com.org.meli.ejercicioBlog.controller;

import com.org.meli.ejercicioBlog.dto.EntradaBlogDto;
import com.org.meli.ejercicioBlog.dto.response.NuevaEntradaBlogDto;
import com.org.meli.ejercicioBlog.service.IBlogService;
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
