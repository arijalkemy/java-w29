package com.mercadolibre.bootcamp.showroom.controller;

import com.mercadolibre.bootcamp.showroom.dto.GarmentDTO;
import com.mercadolibre.bootcamp.showroom.dto.MessageDTO;
import com.mercadolibre.bootcamp.showroom.service.IGarmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garment")
public class GarmentController {

    private final IGarmentService garmentService;

    public GarmentController(IGarmentService garmentService) {
        this.garmentService = garmentService;
    }

    @PostMapping("")
    public ResponseEntity<MessageDTO> create(@RequestBody GarmentDTO garmentDTO) {
        return ResponseEntity.ok(garmentService.save(garmentDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<GarmentDTO>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer size
    ) {
        return ResponseEntity.ok(garmentService.searchAll(name, size));
    }

    @GetMapping("/{code}")
    public ResponseEntity<GarmentDTO> getById(@PathVariable Long code) {
        return ResponseEntity.ok(garmentService.searchById(code));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Long code) {
        return ResponseEntity.ok(garmentService.deleteById(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<MessageDTO> updateById(
            @PathVariable Long code,
            @RequestBody GarmentDTO garmentDTO
    ){
        garmentService.updateById(code, garmentDTO);
        return ResponseEntity.ok(new MessageDTO("Garment updated"));
    }

}
