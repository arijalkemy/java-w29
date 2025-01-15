package com.thiagoschreck.local.link_tracker.controller;

import com.thiagoschreck.local.link_tracker.dto.request.NewLinkRequestDTO;
import com.thiagoschreck.local.link_tracker.dto.response.LinkMetricsResponseDTO;
import com.thiagoschreck.local.link_tracker.dto.response.NewLinkResponseDTO;
import com.thiagoschreck.local.link_tracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class LinkTrackerController {
    private final ILinkTrackerService service;

    @Autowired
    public LinkTrackerController(ILinkTrackerService service) {
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<NewLinkResponseDTO> addLink(@RequestBody NewLinkRequestDTO newLink) {
        return ResponseEntity.ok(service.addLink(newLink));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<HttpHeaders> redirectTo(@PathVariable("linkId") Integer linkId,
                                                  @RequestParam(value = "password", required = false) String password) {
        return new ResponseEntity<>(service.redirectTo(linkId, password), HttpStatus.SEE_OTHER);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsResponseDTO> getMetrics(@PathVariable("linkId") Integer linkId) {
        return ResponseEntity.ok(service.getMetrics(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable("linkId") Integer linkId) {
        return new ResponseEntity<>(service.invalidateLink(linkId), HttpStatus.NO_CONTENT);
    }
}
