package com.example.movies.controller;

import com.example.movies.dto.response.EpisodeDto;
import com.example.movies.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episode")
public class EpisodeController {
    @Autowired
    IEpisodeService iEpisodeService;

    @GetMapping("/actor/{name}/{lastname}")
    public ResponseEntity<List<EpisodeDto>> getEpisodesByActorName(
            @PathVariable String name,
            @PathVariable String lastname
    ){
        return ResponseEntity.ok(iEpisodeService.searchEpisodesByActorName(name, lastname));
    }
}
