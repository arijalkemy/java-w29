package com.example.deportes.controller;

import com.example.deportes.model.entity.Sport;
import com.example.deportes.service.SportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@AllArgsConstructor
public class SportRestController {
    private final SportService sportService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> getAll() {
        return ResponseEntity.ok(sportService.getAllSports());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Sport> getSportByName(@PathVariable String name) {
        return ResponseEntity.ok(sportService.getSportByName(name));
    }


}
