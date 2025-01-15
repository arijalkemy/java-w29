package com.example.ejemploSpring.controller;

import com.example.ejemploSpring.dto.ClientDto;
import com.example.ejemploSpring.service.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private IClientService service;

    public ClientController(IClientService service){
        this.service = service;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> searchClientByName(@PathVariable String name){
        return new ResponseEntity<>(service.getClientByName(name), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveClient(@RequestBody ClientDto clientDto){
        return new ResponseEntity<>(service.saveClient(clientDto), HttpStatus.OK);
    }
}
