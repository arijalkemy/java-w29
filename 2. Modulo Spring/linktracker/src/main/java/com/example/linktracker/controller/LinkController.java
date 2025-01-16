package com.example.linktracker.controller;

import com.example.linktracker.dto.LinkDto;
import com.example.linktracker.repository.LinkRepository;
import com.example.linktracker.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<?> saveLink(@RequestBody LinkDto linkDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(linkService.saveLink(linkDto));
    }

    @GetMapping("/link/redirect/{id}")
    public ResponseEntity<?> redirect(@PathVariable Integer id, HttpServletResponse httpResponse){
        LinkDto link = linkService.findById(id);
        try{
            httpResponse.sendRedirect("https://"+link.url());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No fue posible redigir.");
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<?> getMetrics(@PathVariable Integer linkID){
        return ResponseEntity.ok(linkService.getMetrics(linkID));
    }

    @DeleteMapping("/invalidate/{linkID}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer linkID){
        linkService.invalidateLink(linkID);
        return ResponseEntity.status(HttpStatus.OK).body("El Link con el ID: "+linkID+" fue invalidado correctamente");
    }

}
