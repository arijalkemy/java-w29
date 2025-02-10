package org.example.linktracker.controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.linktracker.dtos.LinkUrlDto;
import org.example.linktracker.dtos.LinkIdDto;
import org.example.linktracker.services.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@Validated
public class LinkController {

    private final LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkIdDto> addLink(
            @Valid @RequestBody LinkUrlDto linkDtoRequest,
            @RequestHeader("password") String password) {
        LinkIdDto response = linkService.createLink(linkDtoRequest, password);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .build(response.id());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirect(
            @PathVariable Long linkId,
            HttpServletResponse response,
            @RequestHeader("password") String password) throws IOException {
        String url = linkService.redirect(linkId, password);
        response.sendRedirect(url);
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).build();
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
