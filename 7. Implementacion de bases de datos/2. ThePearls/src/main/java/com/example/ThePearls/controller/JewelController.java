package com.example.ThePearls.controller;

import com.example.ThePearls.dto.request.JewelDtoRequest;
import com.example.ThePearls.service.IJewelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jewerly")
public class JewelController {
    private final IJewelService iJewelService;

    @PostMapping("/new")
    public ResponseEntity<?> addNewJewel(@RequestBody JewelDtoRequest request) {
        return new ResponseEntity<>(iJewelService.addNewJewel(request), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllJewelry() {
        return new ResponseEntity<>(iJewelService.getAllJewelry(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewelById(@PathVariable Long id) {
        return new ResponseEntity<>(iJewelService.deleteJewelById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJewelById(@PathVariable Long id, @RequestBody JewelDtoRequest request) {
        return new ResponseEntity<>(iJewelService.updateJewelById(id, request), HttpStatus.OK);
    }
}
