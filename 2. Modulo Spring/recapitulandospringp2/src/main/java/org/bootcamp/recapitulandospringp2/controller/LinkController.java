package org.bootcamp.recapitulandospringp2.controller;

import org.bootcamp.recapitulandospringp2.dto.request.LinkDto;
import org.bootcamp.recapitulandospringp2.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {

    private final ILinkService linkService;

    @Autowired
    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<?> crearLink(@RequestBody LinkDto linkDto) {
        return new ResponseEntity<>(this.linkService.crearLink(linkDto), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redireccionarUrl(@PathVariable Integer linkId, @RequestParam String linkPassword) {
        linkService.validatePassword(linkPassword);
        String url = this.linkService.redireccionar(linkId);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }

    @GetMapping("/metricas/{linkId}")
    public ResponseEntity<?> getCantidadVisitas(@PathVariable Integer linkId) {
        return new ResponseEntity<>(this.linkService.getCantidadVisitas(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer linkId) {
        linkService.invalidateLink(linkId);
        return new ResponseEntity<>("Link invalidado", HttpStatus.OK);
    }
}
