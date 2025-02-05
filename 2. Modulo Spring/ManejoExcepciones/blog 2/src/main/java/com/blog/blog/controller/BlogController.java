package com.blog.blog.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.model.EntradaBlog;
import com.blog.blog.service.BlogService;

@RestController
public class BlogController {


    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlog(@PathVariable int id) {
        return null;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> postBlog(@RequestBody EntradaBlog entrada) {
        int id = blogService.addblog(entrada);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogs() {
        return null;
    }
    


}
