package com.example.controller;

import com.example.dto.LinkDto;
import com.example.entities.Link;
import com.example.repository.ILinkRepository;
import com.example.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/link")
public class LinkController {

    ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<?> createLink(@RequestBody LinkDto linkDto) {
        if(isValidUrl(linkDto.getUrl()) || linkDto.isValid()) {
            LinkDto link = linkService.agregarLink(linkDto);
            return new ResponseEntity<>(Map.of("linkId", link.getId()), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("URL no valida",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable Integer linkId,
                                      @RequestParam String password,
                                      HttpServletResponse response ) throws IOException {
        LinkDto linkDto = linkService.redireccionar(linkId);
        if(password.equals(linkDto.getPassword())) {
            response.sendRedirect(linkDto.getUrl());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Password incorrecto",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getLinkMetrics(@PathVariable Integer linkId ) {
        LinkDto link = linkService.getLinkById(linkId);
        return new ResponseEntity<>("Se redireccionó " +link.getContador(),HttpStatus.OK);
    }
    @GetMapping("/links")
    public ResponseEntity<?> getAllLinks() {
        return new ResponseEntity<>(linkService.getAllLinks(),HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer linkId) {
        return new ResponseEntity<>(linkService.invalidateLink(linkId),HttpStatus.OK);
    }

    private boolean isValidUrl(String url) {
        return url.startsWith("http://") || url.startsWith("https://");
    }

}
