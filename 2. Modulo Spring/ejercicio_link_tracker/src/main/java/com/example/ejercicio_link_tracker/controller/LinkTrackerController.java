package com.example.ejercicio_link_tracker.controller;

import com.example.ejercicio_link_tracker.dto.*;
import com.example.ejercicio_link_tracker.service.ILinkTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class LinkTrackerController {
    private final ILinkTrackerService linkTrackerService;

    @PostMapping("/link")
    public ResponseEntity<ResponseLinkDTO> createLink(@RequestBody RequestLinkDTO newLink){
        ResponseLinkDTO responseUrlDTO = linkTrackerService.createLink(newLink);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUrlDTO);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<String> redirectToLink(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(linkTrackerService.getById(id)))
                .build();
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<Integer> metricsLink(@PathVariable Integer id){
        
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer id){

    }
}
