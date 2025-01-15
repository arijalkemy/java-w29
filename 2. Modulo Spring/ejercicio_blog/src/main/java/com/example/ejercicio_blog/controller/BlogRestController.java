package com.example.ejercicio_blog.controller;

import com.example.ejercicio_blog.dto.EntradaBlogDto;
import com.example.ejercicio_blog.services.EntradaServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/blogs")
public class BlogRestController {
    private EntradaServiceImpl entradaService;

    @PostMapping({"", "/"})
    public ResponseEntity<?> createEntry(@RequestBody EntradaBlogDto entrada) {
        return new ResponseEntity<>(entradaService.add(entrada), HttpStatus.CREATED);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> listAllEntries() {
        return new ResponseEntity<>(entradaService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntryById(@PathVariable Integer id) {
        return new ResponseEntity<>(entradaService.findById(id), HttpStatus.OK);
    }


}
