package com.mdaneri.linktrackerspringp2vivo.controller;

import com.mdaneri.linktrackerspringp2vivo.dto.LinkDto;
import com.mdaneri.linktrackerspringp2vivo.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.io.IOException;

@RestController
public class LinkController {

    private final ILinkService ls;

    public LinkController(ILinkService ls) {
        this.ls = ls;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody LinkDto linkDto) {
        ls.save(linkDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("{ 'link': '" + linkDto.getUrl() + "'}");
    }

    @GetMapping("/link/{linkId}")
    public void redirect(HttpServletResponse response, @PathVariable String linkId) throws IOException {
        LinkDto link = ls.findById(linkId);
        response.sendRedirect(link.getUrl());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> redirect(@PathVariable String linkId) {
        LinkDto link = ls.findById(linkId);
        return ResponseEntity.ok(link.getCount());
    }

    @GetMapping("/invalidate/{linkId}")
    public ResponseEntity<Integer> invalidate(@PathVariable String linkId) {
        LinkDto link = ls.remove(linkId);
        return ResponseEntity.status(HttpStatus.OK).body(link.getCount());
    }








}
