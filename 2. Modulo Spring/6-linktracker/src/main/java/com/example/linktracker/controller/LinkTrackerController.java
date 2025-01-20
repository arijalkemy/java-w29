package com.example.linktracker.controller;

import com.example.linktracker.dto.request.LinkDtoIn;
import com.example.linktracker.dto.response.LinkAllDtoOut;
import com.example.linktracker.dto.response.LinkDtoOut;
import com.example.linktracker.dto.response.LinkMetricsDto;
import com.example.linktracker.exception.NotFoundException;
import com.example.linktracker.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LinkTrackerController {

    private final ILinkService iLinkService;

    @PostMapping("/link")
    public ResponseEntity<LinkDtoOut> postLink(
          @RequestBody LinkDtoIn linkDtoIn
    ) throws MalformedURLException {
        return new ResponseEntity<>(this.iLinkService.addLink(linkDtoIn), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> getLink(
            @PathVariable Integer linkId,
            @RequestParam String password,
            HttpServletResponse response
    ) throws IOException {
        try {
            String redirectUrl = iLinkService.redirectLinkById(linkId, password);
            response.sendRedirect(redirectUrl);
            return ResponseEntity.status(HttpStatus.OK).body(this.iLinkService.updateVisitCounter(linkId));
        } catch (NotFoundException e) {
            this.iLinkService.updateValidUrl(linkId, false);
            throw new NotFoundException("No se ha encontrado una url válida");
        }
    }

    @GetMapping("/link/all")
    public ResponseEntity<List<LinkAllDtoOut>> getAll(){
        return new ResponseEntity<>(this.iLinkService.searchAll(), HttpStatus.OK);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsDto> getMetrics(
            @PathVariable Integer linkId
    ){
        return new ResponseEntity<>(this.iLinkService.getMetrics(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> postInvalidateLink(
            @PathVariable Integer linkId
    ){
        return new ResponseEntity<>(this.iLinkService.invalidateById(linkId), HttpStatus.OK);
    }

}
