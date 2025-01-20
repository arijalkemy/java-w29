package com.example.blog_exercise.controller;


import com.example.blog_exercise.entity.EntradaBlog;
import com.example.blog_exercise.service.IBlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping()
    public List<EntradaBlog> getAll(){
        return blogService.getAllBlogs();
    }

    @GetMapping("/{id}")
    public Optional<EntradaBlog> getBlogById(@PathVariable Long id){
        return blogService.getBlogById(id);
    }

    @PostMapping
    public Long saveBlog(@RequestBody EntradaBlog entradaBlog){
        return blogService.saveBlog(entradaBlog);
    }
}
