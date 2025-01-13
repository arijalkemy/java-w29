package org.example.linktracker.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.linktracker.dtos.LinkUrlDto;
import org.example.linktracker.dtos.LinkIdDto;
import org.example.linktracker.services.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@Validated
public class LinkController {

    private final LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkIdDto> addLink(
            @Valid @RequestBody LinkUrlDto linkDtoRequest,
            @RequestParam String password
    ) {
        LinkIdDto response = linkService.createLink(linkDtoRequest, password);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .build(response.id());
        return ResponseEntity.created(location).body(response);
    }

    // Falta redireccionar nomás
    @GetMapping("/link/{linkId}")
    public ResponseEntity<String> redirect(@PathVariable Long linkId) {
        String url = linkService.redirect(linkId);
        return ResponseEntity.ok(url);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<String> metrics(@PathVariable Long linkId) {
        return ResponseEntity.ok(String.format("Cantidad de redirecciones: %d", linkService.getMetrics(linkId)));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable Long linkId) {
        linkService.invalidate(linkId);
        return ResponseEntity.ok("Link invalidado con éxito");
    }

}
