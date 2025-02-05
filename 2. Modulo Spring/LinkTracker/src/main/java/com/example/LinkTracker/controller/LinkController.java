package com.example.LinkTracker.controller;

import com.example.LinkTracker.dto.LinkDTO;
import com.example.LinkTracker.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/link")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createLink(@RequestBody LinkDTO link){
        return new ResponseEntity<>(linkService.createLink(link), HttpStatus.OK);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<String> redirect(@PathVariable Integer linkId){
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", linkService.redirect(linkId))
                .build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> stats(@PathVariable Integer linkId){
        return new ResponseEntity<>(linkService.stats(linkId), HttpStatus.OK);
    }

    @GetMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidate(@PathVariable Integer linkId){
        linkService.invalidate(linkId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
