package com.example.showroom.controller;

import com.example.showroom.dto.ClotheDto;
import com.example.showroom.service.ClotheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
@RequiredArgsConstructor
public class ClotheController {

    private final ClotheService clotheService;

    @GetMapping
    public ResponseEntity<List<ClotheDto>> getClothes(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String size) {
        return ResponseEntity.ok(clotheService.getClothes(name, size));
    }

    @PostMapping
    public ResponseEntity<String> createClothe(@RequestBody ClotheDto clotheDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clotheService.createClothe(clotheDto));
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClotheDto> getClotheByCode(@PathVariable Integer code) {
        return ResponseEntity.ok(clotheService.getClotheByCode(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClotheDto> updateClothe(@PathVariable Integer code, @RequestBody ClotheDto clotheDto) {
        return ResponseEntity.ok(clotheService.updateClothe(code, clotheDto));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteClothe(@PathVariable Integer code) {
        clotheService.deleteClothe(code);
        return ResponseEntity.noContent().build();
    }
}
