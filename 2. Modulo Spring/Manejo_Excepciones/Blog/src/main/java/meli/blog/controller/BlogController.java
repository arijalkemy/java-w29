package meli.blog.controller;

import meli.blog.dto.BlogDto;
import meli.blog.service.IBlogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    IBlogservice blogservice;

    @PostMapping("/blog")
    public ResponseEntity<?>  saveBlog(@RequestBody BlogDto blogDto) {
        return new ResponseEntity<>("Blog creado correctamente con id: " + blogservice.create(blogDto), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> findBlog(@PathVariable Integer id){
        return new ResponseEntity<>(blogservice.findBlog(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(blogservice.getAll(), HttpStatus.OK);
    }
}
