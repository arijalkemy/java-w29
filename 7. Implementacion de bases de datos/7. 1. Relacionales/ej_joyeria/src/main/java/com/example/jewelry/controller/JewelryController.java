package com.example.jewelry.controller;

import com.example.jewelry.model.Jewelry;
import com.example.jewelry.service.JewelryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
@RequiredArgsConstructor
public class JewelryController {

    private final JewelryService service;

    @GetMapping
    public ResponseEntity<List<Jewelry>> getJewelry() {
        return ResponseEntity.ok(service.getJewelry());
    }

    @PostMapping("/new")
    public ResponseEntity<Jewelry> saveJewelry(@RequestBody Jewelry jewelry) {
        service.saveJewelry(jewelry);
        return ResponseEntity.ok(jewelry);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jewelry> getJewelry(@PathVariable Long id) {
        return ResponseEntity.ok(service.findJewelry(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJewelry(@PathVariable Long id) {
        service.deleteJewelry(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Jewelry> editJewelry(@PathVariable Long id, @RequestBody Jewelry jewelry) {
        service.updateJewelry(id, jewelry);
        return ResponseEntity.ok(jewelry);
    }
}
