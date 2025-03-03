package com.opshowroom.showroom.controller;

import com.opshowroom.showroom.domain.Clothe;
import com.opshowroom.showroom.dto.request.ClotheDTO;
import com.opshowroom.showroom.dto.response.ResponseDTO;
import com.opshowroom.showroom.service.IClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    private final IClotheService clotheService;

    @Autowired
    public ClothesController(IClotheService clotheService) {
        this.clotheService = clotheService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createClothe(@RequestBody ClotheDTO clothe) {
        Clothe clotheSaved = clotheService.createClothe(clothe);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ResponseDTO<>(clotheSaved, "Clothe created successfully"));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllClothes() {
        List<ClotheDTO> clothes = clotheService.getClothes();
        return ResponseEntity.ok(new ResponseDTO<>(clothes, "Clothes retrieved successfully"));
    }

    @GetMapping("/{code}")
    public ResponseEntity<ResponseDTO> getClothe(@PathVariable Long code) {
        ClotheDTO clothe = clotheService.getClothe(code);
        return ResponseEntity.ok(new ResponseDTO<>(clothe, "Clothe retrieved successfully"));
    }

    @PutMapping("/{code}")
    public ResponseEntity<ResponseDTO> updateClothe(@PathVariable Long code, @RequestBody ClotheDTO clothe) {
        ClotheDTO clotheUpdated = clotheService.updateClothe(code, clothe);
        return ResponseEntity.ok(new ResponseDTO<>(clotheUpdated, "Clothe updated successfully"));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<ResponseDTO> deleteClothe(@PathVariable Long code) {
        ClotheDTO clotheDeleted = clotheService.deleteClothe(code);
        return ResponseEntity.ok(new ResponseDTO<>(clotheDeleted, "Clothe deleted successfully"));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<ResponseDTO> getClothesBySize(@PathVariable String size) {
        List<ClotheDTO> clothes = clotheService.getClothesBySize(size);
        return ResponseEntity.ok(new ResponseDTO<>(clothes, "Clothes retrieved successfully"));
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO> getClothesByWordInName(@RequestParam("name") String word) {
        List<ClotheDTO> clothes = clotheService.getClothesByWordInName(word);
        return ResponseEntity.ok(new ResponseDTO<>(clothes, "Clothes retrieved successfully"));
    }

}