package org.melibootcamp.links.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.melibootcamp.links.dto.LinkDTo;
import org.melibootcamp.links.entity.Link;
import org.melibootcamp.links.services.IServiceLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class LinkController {
    @Autowired
    IServiceLink serviceLink;
    ObjectMapper om =new ObjectMapper();

    @PostMapping("link")
    public ResponseEntity<?> crearLink(@RequestBody LinkDTo linkDTo){
        Link link=new Link(linkDTo.getUrl());
        return new ResponseEntity<>(serviceLink.crear(link), HttpStatus.OK);
    }
    @GetMapping("link/{id}")
    public ResponseEntity<?> recuperarLink(@PathVariable Long id){
        return new ResponseEntity<>(serviceLink.buscar(id),HttpStatus.OK);
    }
    @GetMapping("metrics/{linkID}")
    public ResponseEntity<?> metricas(@PathVariable Long id){
        return new ResponseEntity<>(serviceLink.metricas(id),HttpStatus.OK);
    }
    @PostMapping("invalidate/{linkID}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        serviceLink.borrar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
