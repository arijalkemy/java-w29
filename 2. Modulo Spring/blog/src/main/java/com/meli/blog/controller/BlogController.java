package com.meli.blog.controller;

import com.meli.blog.dto.request.CreateBlogDto;
import com.meli.blog.dto.response.CreatedBlogDto;
import com.meli.blog.dto.response.ResponseDto;
import com.meli.blog.entity.Blog;
import com.meli.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private IBlogService blogService;

    @Autowired
    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<?> saveBlog(@RequestBody CreateBlogDto blog) {
        ResponseDto<CreatedBlogDto> responseDto = new ResponseDto<>(this.blogService.save(blog), HttpStatus.CREATED.value(), true);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllBlog() {
        ResponseDto<List<Blog>> responseDto = new ResponseDto<>(this.blogService.findAllBlogs(), HttpStatus.OK.value(), true);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlog(@PathVariable Integer id) {
        ResponseDto<Blog> responseDto = new ResponseDto<>(this.blogService.getBlogById(id), HttpStatus.OK.value(), true);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
