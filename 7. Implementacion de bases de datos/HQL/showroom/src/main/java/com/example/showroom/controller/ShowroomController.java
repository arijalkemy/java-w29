package com.example.showroom.controller;

import com.example.showroom.dto.ClotheDto;
import com.example.showroom.service.IClotheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShowroomController {

    private final IClotheService clotheService;

    @GetMapping("/clothes")
    public ResponseEntity<List<ClotheDto>> getClothes(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String size) {
        return ResponseEntity.ok(clotheService.getClothes(name, size));
    }

    @PostMapping("/clothes")
    public ResponseEntity<String> createClothe(@RequestBody ClotheDto clotheDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clotheService.createClothe(clotheDto));
    }

    @GetMapping("/clothes/{code}")
    public ResponseEntity<ClotheDto> getClotheByCode(@PathVariable Integer code) {
        return ResponseEntity.ok(clotheService.getClotheByCode(code));
    }

    @PutMapping("/clothes/{code}")
    public ResponseEntity<String> updateClothe(@PathVariable Integer code, @RequestBody ClotheDto clotheDto) {
        return ResponseEntity.ok(clotheService.updateClothe(code, clotheDto));
    }

    @DeleteMapping("/clothes/{code}")
    public ResponseEntity<String> deleteClothe(@PathVariable Integer code) {
        clotheService.deleteClothe(code);
        return ResponseEntity.noContent().build();
    }
}
