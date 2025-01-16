package com.practicablogexepcion.blogexepcion.controller;

import com.practicablogexepcion.blogexepcion.dto.request.AddBlogRequestDTO;
import com.practicablogexepcion.blogexepcion.dto.response.BlogResponseDTO;
import com.practicablogexepcion.blogexepcion.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
