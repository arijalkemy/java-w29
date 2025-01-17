package com.meli.linktracker.controller;

import com.meli.linktracker.dto.request.LinkDto;
import com.meli.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {

    private ILinkService linkService;

    @Autowired
    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<?> crearLink(@RequestBody LinkDto linkDto, @RequestParam String password) {
        return new ResponseEntity<>(this.linkService.crearLink(linkDto, password), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redireccionarUrl(@PathVariable Integer linkId){
        String url = this.linkService.redireccionar(linkId);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("http://"+url))
                .build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> obtenerMetricas(@PathVariable Integer linkId){
        return new ResponseEntity<>(this.linkService.obtenerMetricas(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidarLink(@PathVariable Integer linkId) {
        this.linkService.invalidar(linkId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
