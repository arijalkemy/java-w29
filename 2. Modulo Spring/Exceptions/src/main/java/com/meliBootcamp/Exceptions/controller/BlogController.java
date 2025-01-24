package com.meliBootcamp.Exceptions.controller;

import Utils.MyMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meliBootcamp.Exceptions.dto.BlogDTO;
import com.meliBootcamp.Exceptions.entity.Blog;
import com.meliBootcamp.Exceptions.exceptions.CastException;
import com.meliBootcamp.Exceptions.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    @Autowired
    IBlogService blogService;
    @PostMapping("/blog")
    public ResponseEntity<?> crearBlog(@RequestBody BlogDTO dto){
        Blog blog=new ObjectMapper().convertValue(dto, Blog.class);

       return new ResponseEntity<>(blogService.crearPost(blog),HttpStatus.OK);
    }
    @GetMapping("/blog")
    public ResponseEntity<?> buscarBLogs(){
        return new ResponseEntity<>(blogService.listarBLogs(),HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable String id){
        return new ResponseEntity<>(blogService.devolverBLog(id),HttpStatus.OK);
    }
}
