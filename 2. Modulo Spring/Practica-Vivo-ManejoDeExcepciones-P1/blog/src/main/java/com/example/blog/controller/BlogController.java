package com.example.blog.controller;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.service.IBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

    private final IBlogService iBlogService;

    /*@PostMapping
    public ResponseEntity<?> crearEntradaBlog(
            @RequestBody EntradaBlogDto entradaBlog
    ){
        return new ResponseEntity<>(this.iBlogService.crearEntradaBlog(entradaBlog), HttpStatus.OK);
    }
    */

    // 1. crear entrda
    @PostMapping
    public ResponseEntity<?> crearEntradaBlog(
            @RequestBody EntradaBlogDto entradaBlog
    ){
        return new ResponseEntity<>(this.iBlogService.crearEntradaBlog(entradaBlog), HttpStatus.OK);
    }

    // 2. get blog
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerBlogPorId(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(this.iBlogService.getBlogById(id), HttpStatus.OK);
    }

    // 3. traer todos
    @GetMapping("/blogs")
    public ResponseEntity<?> obtenerTodos(){
        return new ResponseEntity<>(this.iBlogService.getAll(), HttpStatus.OK);
    }
}
