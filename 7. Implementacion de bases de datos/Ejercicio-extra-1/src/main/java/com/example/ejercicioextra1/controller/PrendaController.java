package com.example.ejercicioextra1.controller;

import com.example.ejercicioextra1.dto.request.PostPrendasRequestDto;
import com.example.ejercicioextra1.service.prenda.PrendaserviceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clothes")
@AllArgsConstructor
public class PrendaController {
    private final PrendaserviceImpl prendaService;

    @PostMapping
    public ResponseEntity<?> postClothes(@RequestBody PostPrendasRequestDto postPrendasRequestDto) {
        return new ResponseEntity<>(prendaService.save(postPrendasRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getClothes(
            @RequestParam(required = false, defaultValue = "") String talle,
            @RequestParam(required = false, defaultValue = "") String name) {
        return new ResponseEntity<>(prendaService.findAll(talle, name), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClothesById(@PathVariable Long id) {
        return new ResponseEntity<>(prendaService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClothesById(@PathVariable Long id) {
        prendaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyClothesById(@PathVariable Long id, @RequestBody PostPrendasRequestDto postPrendasRequestDto) {
        prendaService.modifyById(id, postPrendasRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
