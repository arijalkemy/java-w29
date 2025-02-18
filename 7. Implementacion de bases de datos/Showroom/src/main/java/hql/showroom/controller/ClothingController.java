package hql.showroom.controller;

import hql.showroom.dto.request.ClothingRequestDTO;
import hql.showroom.dto.response.ClothingResponseDTO;
import hql.showroom.service.ClothingServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothingController {

    private final ClothingServiceImpl clothingService;

    public ClothingController(ClothingServiceImpl clothingService) {
        this.clothingService = clothingService;
    }

    @PostMapping
    public ResponseEntity<ClothingResponseDTO> createClothing(@RequestBody ClothingRequestDTO clothing) {
        return ResponseEntity.status(201).body( clothingService.createClothing(clothing));
    }

    @GetMapping
    public ResponseEntity<List<ClothingResponseDTO>> getAllClothes() {
        return ResponseEntity.status(201).body( clothingService.getAllClothes());
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClothingResponseDTO> getClothingByCode(@PathVariable String code) {
        return ResponseEntity.ok(clothingService.getClothingByCode(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClothingResponseDTO> updateClothing(@PathVariable String code, @RequestBody ClothingRequestDTO updatedClothing) {
        return ResponseEntity.ok(clothingService.updateClothing(code, updatedClothing));
    }


    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteClothing(@PathVariable String code) {
        clothingService.deleteClothing(code);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClothingResponseDTO>> getClothesBySize(@PathVariable String size) {
        return ResponseEntity.ok(clothingService.getClothesBySize(size));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ClothingResponseDTO>> searchClothesByName(@RequestParam String name) {
        return ResponseEntity.ok(clothingService.searchClothesByName(name));
    }


}
