package com.meli.blog.controller;

import com.meli.blog.dto.BlogDto;
import com.meli.blog.dto.response.BlogListResponseDto;
import com.meli.blog.dto.response.BlogResponseDto;
import com.meli.blog.service.IBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    private IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable Integer id) {
        return ResponseEntity.ok(this.blogService.getById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<BlogListResponseDto> getBlogs() {
        BlogListResponseDto blogListResponseDto = new BlogListResponseDto(
                this.blogService.getAll(),
                "AAF@!!!1214s"
        );
        return ResponseEntity.ok(blogListResponseDto);
    }

    @PostMapping("/blog")
    public ResponseEntity<BlogResponseDto> createBlog(@RequestBody BlogDto blogDto) {
        BlogDto blogDtoR = this.blogService.save(blogDto);
        BlogResponseDto blogResponseDto = new BlogResponseDto(
                blogDtoR.getId(),
                "El blog ha sido registrado exitosamente!"
        );
        return ResponseEntity.ok(blogResponseDto);
    }
}
