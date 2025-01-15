package com.api.blog.controller;

import com.api.blog.dto.BlogDTO;
import com.api.blog.entity.EntradaBlog;
import com.api.blog.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService service = new BlogService();

    @PostMapping
    public ResponseEntity<String> createBlog(@RequestParam Integer id,
                                             @RequestParam String titulo,
                                             @RequestParam String autor) {
        service.createBlog(id, titulo, autor);
        return ResponseEntity.ok("Entrada de blog creada correctamente con ID: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable Integer id) {
        BlogDTO blog = service.getBlogById(id);
        return ResponseEntity.ok(blog);
    }

    @GetMapping("/blogs")
    public ResponseEntity<Map<Integer, EntradaBlog>> getAllBlogs() {
        return ResponseEntity.ok(service.getAllBlogs());
    }
}
