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
    public ResponseEntity<?> addBlog(@PathVariable int id ){

        return new ResponseEntity<>(blogService.getBlogById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> addBlog(){
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }

}
