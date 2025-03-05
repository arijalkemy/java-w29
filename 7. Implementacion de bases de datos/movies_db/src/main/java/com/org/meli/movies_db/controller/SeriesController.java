package com.org.meli.movies_db.controller;

import com.org.meli.movies_db.dto.SerieDto;
import com.org.meli.movies_db.dto.SeriesByGenreDto;
import com.org.meli.movies_db.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
@Validated
public class SeriesController {

    private final SeriesService seriesService;

    @GetMapping
    public ResponseEntity<List<SerieDto>> getAll() {
        return ResponseEntity.ok(seriesService.getAll());
    }

    @GetMapping("/min-seasons/{minSeasons}")
    public ResponseEntity<List<SerieDto>> getAllWithMinSeasons(@PathVariable Integer minSeasons) {
        return ResponseEntity.ok(seriesService.getAllWithMinSeasons(minSeasons));
    }

    @GetMapping("/by-genre")
    public ResponseEntity<List<SeriesByGenreDto>> getAllByGenre() {
        return ResponseEntity.ok(seriesService.getAllByGenre());
    }
}