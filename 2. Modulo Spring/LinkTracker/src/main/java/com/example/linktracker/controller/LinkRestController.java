package com.example.linktracker.controller;

import com.example.linktracker.dto.request.LinkDto;
import com.example.linktracker.dto.response.SuccessLinkDto;
import com.example.linktracker.service.ILinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
public class LinkRestController {
    private ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<SuccessLinkDto> createLink(@RequestBody LinkDto link) {
        return ResponseEntity.ok(linkService.create(link));
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<Void> getLink(@PathVariable Integer id) {
        LinkDto link = linkService.getLink(id);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .location(URI.create(link.getUrl()))
                .build();
    }
}
