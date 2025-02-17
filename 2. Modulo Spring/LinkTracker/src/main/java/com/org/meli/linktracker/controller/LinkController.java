package com.org.meli.linktracker.controller;

import com.org.meli.linktracker.dto.CreateLinkRequestDto;
import com.org.meli.linktracker.dto.LinkDto;
import com.org.meli.linktracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/link")
public class LinkController {
    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/create")
    public ResponseEntity<LinkDto> createLink(@RequestBody CreateLinkRequestDto request) {
        return new ResponseEntity<>(linkService.createLink(request.getUrl(), request.getPassword()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> redirect(@PathVariable Long id, @RequestParam String password){
        return new ResponseEntity<>(linkService.getRedirectUrlResponse(id, password), HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkDto> getMetrics(@PathVariable Long id){
        return new ResponseEntity<>(linkService.getMetricsResponse(id), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<String> invalidateLink(@PathVariable Long id){
        return new ResponseEntity<>(linkService.invalidateLinkResponse(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LinkDto>> getAllLinks(){
        return new ResponseEntity<>(linkService.getAllLinks(), HttpStatus.OK);
    }
}
