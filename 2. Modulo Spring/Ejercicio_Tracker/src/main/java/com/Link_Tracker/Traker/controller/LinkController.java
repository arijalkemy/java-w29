package com.Link_Tracker.Traker.controller;

import com.Link_Tracker.Traker.dto.request.LinkDto;
import com.Link_Tracker.Traker.dto.response.LinkResponseDto;
import com.Link_Tracker.Traker.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/link")
public class LinkController {
    private ILinkService service;

    public LinkController(ILinkService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> createLink(@RequestBody LinkDto linkDto){
        return new ResponseEntity<>(service.createLink(linkDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public void redirectToUrl(@PathVariable Integer id, @RequestParam(required = false) String password, HttpServletResponse response) throws IOException {
        LinkResponseDto linkResponse = service.getLinkById(id);

        if (linkResponse.isValido()) {
            response.sendRedirect(linkResponse.getEnmascarado());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "El enlace es inválido.");
        }
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<Void> invalidateLink(@PathVariable Integer id) {
        service.invalidateLink(id);
        return ResponseEntity.noContent().build();
    }
}
