package org.melibootcamp.url_ejercicio.controller;

import lombok.RequiredArgsConstructor;
import org.melibootcamp.url_ejercicio.dto.request.UrlDTORequest;
import org.melibootcamp.url_ejercicio.dto.response.UrlDTO;
import org.melibootcamp.url_ejercicio.dto.response.UrlDeleteDTO;
import org.melibootcamp.url_ejercicio.dto.response.UrlRedirectDto;
import org.melibootcamp.url_ejercicio.service.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping()
    public ResponseEntity<UrlDTO> postUrl(@RequestBody UrlDTORequest urlDTORequest){
        return new ResponseEntity<>(urlService.setUrlValid(urlDTORequest), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Void> redirectWithEntity(@PathVariable Integer id , @RequestParam String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(urlService.getUrl(id,password)));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }


    @GetMapping("/metrics/{id}")
    public ResponseEntity<UrlRedirectDto> getNumRedirects(@PathVariable Integer id){
        return new ResponseEntity<>(urlService.getNumRedirects(id),HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<UrlDeleteDTO> invalidateUrl(@PathVariable Integer id){
        return new ResponseEntity<>(urlService.invalidUrlDTO(id),HttpStatus.OK);
    }
}
