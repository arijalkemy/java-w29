package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.LinkRequestBody;
import com.bootcamp.linktracker.dto.LinkResponseBody;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.service.LinkService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("link")
    public ResponseEntity<LinkResponseBody> saveLink(@RequestBody LinkRequestBody request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(linkService.saveLink(request));
    }

    @GetMapping("link/{linkId}")
    public ResponseEntity<LinkResponseBody> getLink(@PathVariable String linkId, HttpServletResponse response) {
        try {
            response.sendRedirect(linkService.findUrlById(linkId));
            linkService.incrementVisits(linkId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("metrics/{linkId}")
    public ResponseEntity<LinkResponseBody> getMetrics(@PathVariable String linkId) {
        return ResponseEntity.ok(linkService.getMetrics(linkId));
    }

}
