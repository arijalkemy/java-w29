package com.example.moviesHQL.controller;

import com.example.moviesHQL.dto.response.EpisodeDTO;
import com.example.moviesHQL.service.IEpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episode")
@RequiredArgsConstructor
public class EpisodeController {
    private final IEpisodeService episodeService;

    @GetMapping("/actor/{name}")
    ResponseEntity<List<EpisodeDTO>> getEpisodesByActor(@PathVariable String name) {
        return ResponseEntity.ok(episodeService.getEpisodesByActor(name));
    }
}
