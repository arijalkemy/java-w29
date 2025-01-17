package com.example.controller;

import com.example.dto.BlogDto;
import com.example.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping()
    public ResponseEntity<?> crearBlog(@RequestBody BlogDto blogDto) {
        BlogDto blog = blogService.addBlog(blogDto);
        return new ResponseEntity<>("El blog ha con id "+blog.getId()+"ha sido creado", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlog(@PathVariable Integer id) {
        return new ResponseEntity<>(blogService.getBlogById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogs() {
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }

}
