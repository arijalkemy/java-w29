package com.meli.ej_blog.controller;

import com.meli.ej_blog.dto.BlogEntryDTO;
import com.meli.ej_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private final IBlogService blogService;

    @Autowired
    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<String> postBlog(@RequestBody BlogEntryDTO blogEntryDTO) {
        Integer id = this.blogService.createBlogEntry(blogEntryDTO);
        String message = String.format("Entrada de blog creada correctamente. ID: %s", id);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryDTO> getBlog(@PathVariable Integer id) {
        return new ResponseEntity<>(this.blogService.searchBlogEntry(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogEntryDTO>> getBlogs() {
        return new ResponseEntity<>(this.blogService.searchAllBlogEntries(), HttpStatus.OK);
    }

}
