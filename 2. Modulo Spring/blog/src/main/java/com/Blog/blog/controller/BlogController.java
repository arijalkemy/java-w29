package com.Blog.blog.controller;

import com.Blog.blog.dto.AddBlogDto;
import com.Blog.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    private IBlogService blogService;

    public BlogController(IBlogService blogService){
        this.blogService = blogService;

    }

    @PostMapping("/blog")
    public ResponseEntity<?> addBlog(@RequestBody AddBlogDto addBlog ){

        return new ResponseEntity<>(blogService.addBlog(addBlog), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> createBlog(@PathVariable Integer id){
        return new ResponseEntity<>(blogService.getBlog(id),HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<?> getAllBlogs(){
        return new ResponseEntity<>(blogService.getAllBlogs(),HttpStatus.OK);
    }


}
