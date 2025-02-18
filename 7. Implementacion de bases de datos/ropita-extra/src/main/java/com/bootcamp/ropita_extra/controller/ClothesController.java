package com.bootcamp.ropita_extra.controller;

import com.bootcamp.ropita_extra.dto.ClothesDto;
import com.bootcamp.ropita_extra.service.IClothesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {
    private final IClothesService service;

    @Autowired
    public ClothesController(IClothesService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> addClothes(@Valid @RequestBody ClothesDto clothesDto){
        return ResponseEntity.created(URI.create("/api/clothes/" + service.addClothes(clothesDto))).build();
    }

    @GetMapping
    public ResponseEntity<List<ClothesDto>> getAllClothes(@RequestParam(required = false) String name){
        return ResponseEntity.ok(service.findAllClothes(name));
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClothesDto> getClothesByCode(@PathVariable String code){
        return ResponseEntity.ok(service.findClothesByCode(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClothesDto> addClothes(@PathVariable String code, @Valid @RequestBody ClothesDto clothesDto){
        return ResponseEntity.ok(service.updateClothes(code, clothesDto));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteClothes(@PathVariable String code){
        service.deleteClothesByCode(code);
        return ResponseEntity.noContent().build();
    }
}
