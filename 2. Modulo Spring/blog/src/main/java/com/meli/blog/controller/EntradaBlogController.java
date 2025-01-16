package com.meli.blog.controller;

import com.meli.blog.dto.EntradaBlogDTO;
import com.meli.blog.entity.EntradaBlog;
import com.meli.blog.service.EntradaBlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {
    @Autowired
    EntradaBlogServiceImpl entradaBlogService;

    @GetMapping("/blogs")
    public List<EntradaBlogDTO> getEntradaBlog(){
        return entradaBlogService.findAll();
    }

    @PostMapping("/blog")
    public Long saveEntradaBlog(@RequestBody EntradaBlog entradaBlog){
        return entradaBlogService.create(entradaBlog);
    }

    @GetMapping("/blog/{id}")
    public EntradaBlogDTO getEntradaBlogById(@PathVariable("id") Long id){
        return  entradaBlogService.findById(id);
    }
}
