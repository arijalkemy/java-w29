package com.example.calorias.controllers;

import com.example.calorias.dtos.PlateRequestDto;
import com.example.calorias.dtos.PlateResponseDto;
import com.example.calorias.service.PlateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlateController {

    private final PlateService service;

    @GetMapping
    public ResponseEntity<PlateResponseDto> getPlateInfo(@RequestBody PlateRequestDto plateRequestDTO) {
        return ResponseEntity.ok(service.getPlateInfo(plateRequestDTO));
    }

    @GetMapping("/batch")
    public ResponseEntity<List<PlateResponseDto>> getBatchPlateInfo(@RequestBody List<PlateRequestDto> plateRequestDTOs) {
        return ResponseEntity.ok(service.getBatchPlateInfo(plateRequestDTOs));
    }

}
