package com.example.integrador.Controller;

import com.example.integrador.model.Clothes;
import com.example.integrador.service.ClothesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClothesController {

    private final ClothesService clothesService;

    public ClothesController(ClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @GetMapping("/api/clothes")
    public ResponseEntity<?> getClothes(){
        return new ResponseEntity<List<Clothes>>(clothesService.searchAllClothes(),HttpStatus.OK);
    }


}
