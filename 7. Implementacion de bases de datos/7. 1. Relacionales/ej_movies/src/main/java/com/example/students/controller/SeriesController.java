package com.example.students.controller;

import com.example.students.dto.SerieDto;
import com.example.students.dto.SeriesByGenreDto;
import com.example.students.service.SeriesService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<SerieDto>> getAllWithMinSeasons(@PathVariable @Positive Integer minSeasons) {
        return ResponseEntity.ok(seriesService.getAllWithMinSeasons(minSeasons));
    }

    @GetMapping("/by-genre")
    public ResponseEntity<List<SeriesByGenreDto>> getAllByGenre() {
        return ResponseEntity.ok(seriesService.getAllByGenre());
    }
}
