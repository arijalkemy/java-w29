package com.example.ejercicio_links.controller;

import com.example.ejercicio_links.entity.Link;
import com.example.ejercicio_links.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<?> crearLink(@RequestBody Link link) {
        return new ResponseEntity<>(linkService.ingresarLink(link), HttpStatus.OK);
    }

    @GetMapping("link/{linkId}")
    public ResponseEntity<?> redireccion(@PathVariable int linkId){
        return new ResponseEntity<>(linkService.redireccion(linkId),HttpStatus.OK);
    }
}
