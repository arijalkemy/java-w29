package com.bootcamp.linkTracker.controller;

import com.bootcamp.linkTracker.dto.IdDTO;
import com.bootcamp.linkTracker.dto.LinkDTO;
import com.bootcamp.linkTracker.dto.MetricDTO;
import com.bootcamp.linkTracker.exception.InvalidLinkException;
import com.bootcamp.linkTracker.service.ILinkTrackerService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.io.IOException;
import java.net.URI;

@RestController
@RequiredArgsConstructor
public class LinkTrackerController {

    private final ILinkTrackerService service;

    @PostMapping("/link")
    public ResponseEntity<IdDTO> createLink(@RequestBody LinkDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createLink(request));
    }

    @PatchMapping("/link/{linkId}")
    public ResponseEntity<RedirectView> redirect(@PathVariable Integer linkId, @RequestParam String password){
        String link = service.getLinkToRedirectById(linkId, password).getLink();
        return ResponseEntity.status(HttpStatus.FOUND).body(new RedirectView(link));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<MetricDTO> getMetricById(@PathVariable Integer linkId){
        return ResponseEntity.status(HttpStatus.OK).body(service.getMetricsById(linkId));
    }

    @PatchMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLinkById(@PathVariable Integer linkId){
        service.invalidateLinkById(linkId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
