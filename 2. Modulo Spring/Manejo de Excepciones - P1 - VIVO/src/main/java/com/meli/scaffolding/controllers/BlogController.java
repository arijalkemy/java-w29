package com.meli.scaffolding.controllers;

import com.meli.scaffolding.dto.BlogDto;
import com.meli.scaffolding.dto.response.BlogResponseDto;
import com.meli.scaffolding.services.IBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final IBlogService blogService;

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable Integer id) {
        return ResponseEntity.ok(this.blogService.getById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> getBlogs() {
        return ResponseEntity.ok(this.blogService.getAll());
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
