package org.example.link_tracker.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.link_tracker.dto.RequestLinkDTO;
import org.example.link_tracker.dto.ResponseLinkDTO;
import org.example.link_tracker.exception.UnauthorizedException;
import org.example.link_tracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class LinkController {

    private final LinkService service;

    public LinkController(LinkService service) {
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<?> createLink(@RequestBody RequestLinkDTO link) {
        return ResponseEntity.ok(service.addLink(link));
    }

    @GetMapping("/link/{linkId}")
    public void redirect(
            @PathVariable int linkId,
            @RequestParam(required = false) Integer pass,
            HttpServletResponse response
    ) throws IOException {
        if (pass == null){
            throw new UnauthorizedException("Se requiere una contraseña");
        }
        ResponseLinkDTO link = service.redirect(linkId, pass);
        response.sendRedirect(link.getUrl());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> metrics(@PathVariable int linkId) {
        return new ResponseEntity<>(service.getMetrics(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public void invalidate(@PathVariable int linkId) {
        service.invalidateLink(linkId);
    }
}
