package com.example.miniseries.controller;

import com.example.miniseries.model.MiniSerie;
import com.example.miniseries.service.MiniSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class MiniSeriesController {

    private final MiniSeriesService service;

    @GetMapping
    public ResponseEntity<List<MiniSerie>> getStudents() {
        return ResponseEntity.ok(service.getMiniSerie());
    }

    @PostMapping
    public ResponseEntity<MiniSerie> saveStudent(@RequestBody MiniSerie miniSerie) {
        service.saveMiniSerie(miniSerie);
        return ResponseEntity.ok(miniSerie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiniSerie> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(service.findMiniSerie(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteMiniSerie(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<MiniSerie> editStudent(@PathVariable Long id, @RequestBody MiniSerie miniSerie) {
        miniSerie.setId(id);
        service.saveMiniSerie(miniSerie);
        return ResponseEntity.ok(miniSerie);
    }
}
