package com.example.movies.controller;

import com.example.movies.dto.response.SerieDto;
import com.example.movies.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {
    @Autowired
    ISerieService iSerieService;

    @GetMapping("/season/{num}")
    public ResponseEntity<List<SerieDto>> getSerieByNumberOfSeasons(
            @PathVariable Integer num
    ){
        return ResponseEntity.ok(iSerieService.searchSerieByNumberOfSeasons(num));
    }
}
