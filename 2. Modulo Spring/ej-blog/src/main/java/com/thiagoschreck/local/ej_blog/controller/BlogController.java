package com.thiagoschreck.local.ej_blog.controller;

import com.thiagoschreck.local.ej_blog.dto.request.AddBlogRequestDTO;
import com.thiagoschreck.local.ej_blog.dto.response.BlogResponseDTO;
import com.thiagoschreck.local.ej_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BlogController {

    private final IBlogService service;

    @Autowired
    public BlogController(IBlogService service) {
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<BlogResponseDTO> addBlogEntry(@RequestBody AddBlogRequestDTO request) {
        return ResponseEntity.ok(service.addBlogEntry(request));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogResponseDTO> getBlogEntryById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getBlogEntryById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogResponseDTO>> getAllBlogEntries() {
        return ResponseEntity.ok(service.getAllBlogEntries());
    }
}
