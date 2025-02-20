package com.org.meli.showroom.controller;

import com.org.meli.showroom.dto.GarmentDto;
import com.org.meli.showroom.service.IGarmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clothes")
@AllArgsConstructor
public class GarmentController {
    private final IGarmentService serviceGarment;

    @PostMapping
    public ResponseEntity<GarmentDto> postGarment(@RequestBody GarmentDto garmentDto) {
        return new ResponseEntity<>(serviceGarment.saveGarment(garmentDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GarmentDto>> getAllGarments() {
        return new ResponseEntity<>(serviceGarment.getAllGarments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GarmentDto> getGarmentById(@PathVariable Long id) {
        return new ResponseEntity<>(serviceGarment.getGarmentById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GarmentDto> updateGarment(@PathVariable Long id, @RequestBody GarmentDto garmentDto) {
        return new ResponseEntity<>(serviceGarment.updateGarment(id, garmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GarmentDto> deleteGarment(@PathVariable Long id) {
        return new ResponseEntity<>(serviceGarment.deleteGarment(id), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<GarmentDto>> getGarmentBySize(@PathVariable String size) {
        return new ResponseEntity<>(serviceGarment.getGarmentsBySize(size), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<GarmentDto>> getGarmentByName(@RequestParam String name) {
        return new ResponseEntity<>(serviceGarment.getGarmentsByName(name), HttpStatus.OK);
    }

}
