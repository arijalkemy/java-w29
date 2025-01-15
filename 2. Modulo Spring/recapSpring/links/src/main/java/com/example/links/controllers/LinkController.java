package com.example.links.controllers;

import com.example.links.DTOs.LinkCreateDTO;
import com.example.links.DTOs.LinkDTO;
import com.example.links.entity.Link;
import com.example.links.repositories.LinkRepository;
import com.example.links.services.LinkServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {

    private final LinkRepository linkRepository;
    private LinkServiceImpl linkServiceImpl;

    public LinkController(LinkServiceImpl linkService, LinkRepository linkRepository) {
        this.linkServiceImpl = linkService;
        this.linkRepository = linkRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLink(@RequestBody LinkCreateDTO linkDTO) {
        return new ResponseEntity<>(linkServiceImpl.createLink(linkDTO), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirectToUrl(@PathVariable int linkId, @RequestParam(required = false) String password) {
        LinkDTO link = linkServiceImpl.getLink(linkId);
        if (link != null && (link.getPassword() == null || link.getPassword().equals(password))) {
            linkServiceImpl.incrementCount(linkId);
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(link.getUrl())).build();
        }
        return new

}
