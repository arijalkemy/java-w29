package com.example.Blog.controller;

import com.example.Blog.dto.DTOEntradaBlog;
import com.example.Blog.service.IServiceBlog;
import com.example.Blog.service.ServiceBlog;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
public class ControllerBlog {

    private final IServiceBlog serviceBlog;
    public ControllerBlog(IServiceBlog serviceBlog) {
        this.serviceBlog = serviceBlog;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        serviceBlog.findById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        serviceBlog.findAll();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/blog")
    public ResponseEntity<?> addBlog(@RequestBody DTOEntradaBlog blog){
        serviceBlog.addBlog(blog);
        return ResponseEntity.ok().build();
    }
}
