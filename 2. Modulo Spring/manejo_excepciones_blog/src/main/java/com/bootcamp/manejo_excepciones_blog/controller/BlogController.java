package com.bootcamp.manejo_excepciones_blog.controller;

import com.bootcamp.manejo_excepciones_blog.dto.BlogRequestDTO;
import com.bootcamp.manejo_excepciones_blog.dto.BlogResponseDTO;
import com.bootcamp.manejo_excepciones_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<URI> createBlog(@RequestBody BlogRequestDTO blogRequestDTO) {
        Integer id = blogService.createBlog(blogRequestDTO);
        return ResponseEntity.created(URI.create("/blog/" + id)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogResponseDTO> getBlogById(@PathVariable Integer id) {
        BlogResponseDTO blogResponseDTO = blogService.getBlogById(id);
        return ResponseEntity.ok(blogResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<BlogResponseDTO>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }
}
