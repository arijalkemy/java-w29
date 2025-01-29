package org.melibootcamp.url_ejercicio.controller;

import lombok.RequiredArgsConstructor;
import org.melibootcamp.url_ejercicio.dto.request.UrlDTORequest;
import org.melibootcamp.url_ejercicio.dto.response.UrlDTO;
import org.melibootcamp.url_ejercicio.dto.response.UrlStatisticsDto;
import org.melibootcamp.url_ejercicio.service.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping()
    public ResponseEntity<UrlDTO> postUrl(@RequestBody UrlDTORequest urlDTORequest) {
        return new ResponseEntity<>(urlService.setUrlValid(urlDTORequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirectWithEntity(@PathVariable Integer id,
            @RequestParam(required = false) String password) {
        HttpHeaders headers = new HttpHeaders();
        if (password != null) {

            headers.setLocation(URI.create(urlService.getUrl(id)));
        } else {

            headers.setLocation(URI.create(urlService.getUrlPassword(id, password)));
        }
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<UrlStatisticsDto> getMetrics(@PathVariable Integer id) {
        return new ResponseEntity<>(this.urlService.getUrlStatisticsDto(id), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public void postMethodName(@PathVariable Integer id) {
        urlService.invalidateUrl(id);
    }

}
