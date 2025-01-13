package com.bootcamp.ej_starwars_multicapa.controller;

import com.bootcamp.ej_starwars_multicapa.dto.CharacterDTO;
import com.bootcamp.ej_starwars_multicapa.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final ISearchService searchService;

    @Autowired
    public SearchController(ISearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/{query}")
    public ResponseEntity<List<CharacterDTO>> searchCharacters(@PathVariable String query) {
        return ResponseEntity.ok(searchService.searchCharacters(query));
    }
}
