package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogCreatedDTO;
import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService service;

    @PostMapping("/blog")
    public ResponseEntity<BlogCreatedDTO> addBlog(@RequestBody BlogDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addBlog(request));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.getBlog(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getBlogs(){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.getBlogs());
    }
}
