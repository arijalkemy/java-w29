package com.example.moviesHQL.controller;

import com.example.moviesHQL.dto.response.SerieDTO;
import com.example.moviesHQL.service.ISerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SerieController {

    private final ISerieService serieService;

    @GetMapping("/{season}")
    ResponseEntity<List<SerieDTO>> getSeriesBySeasons(@PathVariable Integer season) {
        return ResponseEntity.ok(serieService.getSeriesBySeasons(season));
    }
}
