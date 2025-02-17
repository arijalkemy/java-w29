package com.bootcampw29.jewelry.controller;

import com.bootcampw29.jewelry.dto.request.JewelRequestDTO;
import com.bootcampw29.jewelry.dto.response.JewelCreatedDTO;
import com.bootcampw29.jewelry.dto.response.JewelResponseDTO;
import com.bootcampw29.jewelry.service.JewelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {
    private final JewelService jewelService;

    public JewelController(JewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping("/new")
    public ResponseEntity<JewelCreatedDTO> createJewel(@RequestBody JewelRequestDTO jewelRequestDTO) {
     return new ResponseEntity<>(jewelService.createJewel(jewelRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JewelResponseDTO> updateJewel(
            @PathVariable Long id,
            @RequestBody JewelRequestDTO jewelRequestDTO) {
        return new ResponseEntity<>(jewelService.updateJewel(jewelRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long id) {
        jewelService.deleteJewel(id);
        return new ResponseEntity<>(ResponseEntity.EMPTY, HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<List<JewelResponseDTO>> findSaleJewels() {
        return new ResponseEntity<>(jewelService.findSaleJewels(), HttpStatus.OK);
    }

}
