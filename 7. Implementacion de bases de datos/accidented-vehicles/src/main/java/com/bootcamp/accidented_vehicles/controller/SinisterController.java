package com.bootcamp.accidented_vehicles.controller;

import com.bootcamp.accidented_vehicles.dto.SinisterRequestDto;
import com.bootcamp.accidented_vehicles.dto.SinisterResponseDto;
import com.bootcamp.accidented_vehicles.service.ISinisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sinister")
public class SinisterController {
    private ISinisterService service;

    @Autowired
    public SinisterController(ISinisterService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SinisterResponseDto> createSinister(@RequestBody SinisterRequestDto sinisterDto){
        return ResponseEntity.ok(service.saveSinister(sinisterDto));
    }

    @GetMapping
    public ResponseEntity<List<SinisterResponseDto>> getAlSinisters(){
        return ResponseEntity.ok(service.findAllSinisters());
    }
}
