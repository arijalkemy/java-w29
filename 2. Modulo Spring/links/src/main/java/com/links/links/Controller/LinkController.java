package com.links.links.Controller;

import com.links.links.Dto.LinkDto;
import com.links.links.Service.LinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LinkController {

    @Autowired
    LinkServiceImpl service;


    @PostMapping("/link")
    public ResponseEntity<?> createLink(@RequestBody LinkDto link){

        return ResponseEntity.ok(service.createLink(link));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirectToLink(@PathVariable Integer linkId){

    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> metrics(@PathVariable  String linkId){
        return null;
    }
}
