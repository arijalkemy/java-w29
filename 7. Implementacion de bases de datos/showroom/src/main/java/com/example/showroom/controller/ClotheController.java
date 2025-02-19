package com.example.showroom.controller;

import com.example.showroom.dto.request.ClotheRequestDto;
import com.example.showroom.dto.response.ClotheResponseDto;
import com.example.showroom.service.IClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClotheController {
    @Autowired
    public IClotheService clotheService;

    @PostMapping
    public ResponseEntity<ClotheResponseDto> postNewClothe(@RequestBody ClotheRequestDto clotheRequestDto){
        return new ResponseEntity<>(clotheService.save(clotheRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClotheResponseDto>> getAllClothes(){
        return new ResponseEntity<>(clotheService.searchClothes(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClotheResponseDto> getClotheByCode(){
        return new ResponseEntity<>(clotheService.searchClotheByCode(), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClotheResponseDto> putClotheByCode(@RequestBody ClotheRequestDto clotheRequestDto){
        return new ResponseEntity<>(clotheService.modifyClotheByCode(), HttpStatus.OK);
    }
}
