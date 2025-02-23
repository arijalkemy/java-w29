package com.example.showroom.controller;

import com.example.showroom.model.dto.ClotheDTO;
import com.example.showroom.service.ClotheServiceImpl;
import com.example.showroom.service.IClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clothes")
public class ClotheController {

    @Autowired
    private IClotheService clotheService;


    @PostMapping
    public ResponseEntity<ClotheDTO> save(@RequestBody ClotheDTO clotheDTO) {
        return ResponseEntity.ok(clotheService.save(clotheDTO));
    }

    @GetMapping
    public ResponseEntity<List<ClotheDTO>> findAll(@RequestParam(required = false) String name) {
        if (name != null) {
            return ResponseEntity.ok(clotheService.filterByContainingName(name));
        }
        return ResponseEntity.ok(clotheService.findAll());
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ClotheDTO> findById(@PathVariable Long code) {
        return ResponseEntity.ok(clotheService.findById(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClotheDTO> update(@PathVariable Long code, @RequestBody ClotheDTO clotheDTO) {
        return ResponseEntity.ok(clotheService.update(code, clotheDTO));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> delete(@PathVariable Long code) {
        clotheService.delete(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{size}")
    public ResponseEntity<List<ClotheDTO>> findAllBySize(@PathVariable String size) {
        return ResponseEntity.ok(clotheService.findAllBySize(size));
    }

}

