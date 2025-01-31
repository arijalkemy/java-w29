package com.mercadolibre.javawave29.blog.controller;

import com.mercadolibre.javawave29.blog.dto.BlogDTO;
import com.mercadolibre.javawave29.blog.dto.CreatedDTO;
import com.mercadolibre.javawave29.blog.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final IService service;

    @Autowired
    public BlogController(IService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreatedDTO> createBlog (@RequestBody BlogDTO blogDTO) {
        return service.addBlog(blogDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlogById (@PathVariable Long id) {
        return service.getBlogById(id);
    }

    @GetMapping
    public ResponseEntity<List<BlogDTO>> getBlogs() {
        return service.findAll();
    }

}
