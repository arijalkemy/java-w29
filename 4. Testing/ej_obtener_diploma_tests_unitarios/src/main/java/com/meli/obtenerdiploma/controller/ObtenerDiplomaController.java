package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ObtenerDiplomaController {

    private final ObtenerDiplomaService service;

    @GetMapping("/analyzeScores/{studentId}")
    public StudentDTO analyzeScores(@PathVariable Long studentId) {
        return service.analyzeScores(studentId);
    }
}
