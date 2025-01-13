package com.bootcamp.ej_practicos_p2.controller;

import com.bootcamp.ej_practicos_p2.dto.PlateRequestDTO;
import com.bootcamp.ej_practicos_p2.dto.PlateResponseDTO;
import com.bootcamp.ej_practicos_p2.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plate")
public class PlateController {

    private final PlateService plateService;

    @Autowired
    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }

    @GetMapping
    public ResponseEntity<PlateResponseDTO> getPlateInfo(@RequestBody PlateRequestDTO plateRequestDTO) {
        return ResponseEntity.ok(plateService.getPlateInfo(plateRequestDTO));
    }
}
