package com.bootcamp.link_tracker.controller;

import com.bootcamp.link_tracker.dto.LinkPostResponseDTO;
import com.bootcamp.link_tracker.dto.LinkRequestDTO;
import com.bootcamp.link_tracker.exceptions.LinkNotFoundException;
import com.bootcamp.link_tracker.model.Link;
import com.bootcamp.link_tracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping
public class LinkController {

    private final LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkPostResponseDTO> postLink(@RequestBody LinkRequestDTO linkRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(linkService.save(linkRequestDTO));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirectToLink(@PathVariable Integer linkId) throws LinkNotFoundException, MalformedURLException, URISyntaxException {
        Link link = linkService.redirectLink(linkId);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(link.getLink()));
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).headers(headers).build();

        // return new RedirectView("https://www.google.com/");
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getLinkMetrics(@PathVariable Integer linkId) throws LinkNotFoundException {
        return ResponseEntity.ok(linkService.getMetrics(linkId));
    }
}
