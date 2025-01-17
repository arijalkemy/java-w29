package org.example.ej_blog.Controllers;

import org.example.ej_blog.Dtos.BlogDto;
import org.example.ej_blog.Entities.EntradaBlog;
import org.example.ej_blog.Repositories.BlogRepositoryImpl;
import org.example.ej_blog.Servicies.BlogServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("URI:")
public class BlogController {

    private final BlogServiceImpl service;

    public BlogController(BlogServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> saveBlog(@RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(service.addBlog(blogDto));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> findBlogById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findBlogById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> getAllBlogs() {
        return ResponseEntity.ok(service.getAllBlogs());
    }


}
