package com.opshowroom.showroom.controller;

import com.opshowroom.showroom.domain.Clothe;
import com.opshowroom.showroom.dto.ClotheCreatedDTO;
import com.opshowroom.showroom.dto.ClotheDTO;
import com.opshowroom.showroom.dto.MessageDTO;
import com.opshowroom.showroom.service.IClotheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clothes")
public class Controller {

    private final IClotheService clotheService;

    @GetMapping("")
    public ResponseEntity<List<ClotheDTO>> getAllClothe(@RequestParam(required = false) String word) {
        if(word == null || word.isEmpty()) {
            return new ResponseEntity<>(clotheService.searchClothes(), HttpStatus.OK);
        }
        return new ResponseEntity<>(clotheService.searchClothesByWordInName(word), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<ClotheCreatedDTO> postClothe(@RequestBody ClotheDTO clothe) {
        return new ResponseEntity<>(clotheService.saveClothe(clothe), HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClotheDTO> getClotheByCode(@PathVariable Long code) {
        return new ResponseEntity<>(clotheService.searchByCode(code), HttpStatus.OK);
    }
    @PutMapping("/{code}")
    public ResponseEntity<ClotheDTO> putClothe(@PathVariable Long code, @RequestBody ClotheDTO clothe) {
        return new ResponseEntity<>(clotheService.modifyClothe(code, clothe), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<MessageDTO> deleteClothe(@PathVariable Long code) {
        return new ResponseEntity<>(clotheService.deleteClothe(code), HttpStatus.OK);
    }
    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClotheDTO>> getClothesBySize(@PathVariable Integer size) {
        return new ResponseEntity<>(clotheService.searchClothesBySize(size), HttpStatus.OK);
    }
    /*
    @GetMapping()
    public ResponseEntity<List<ClotheDTO>> getClothesByWordInName(@RequestParam String word) {
        return new ResponseEntity<>(clotheService.searchClothesByWordInName(word), HttpStatus.OK);
    }*/

}