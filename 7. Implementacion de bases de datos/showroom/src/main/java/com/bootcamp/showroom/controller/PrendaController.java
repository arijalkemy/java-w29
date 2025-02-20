package com.bootcamp.showroom.controller;

import com.bootcamp.showroom.dto.PrendaDto;
import com.bootcamp.showroom.service.IPrendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
@RequiredArgsConstructor
public class PrendaController {
    private final IPrendaService prendaService;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody PrendaDto prendaDto){
        PrendaDto saved = prendaService.save(prendaDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll(@RequestParam(required = false) String nombre){
        List<PrendaDto> prendas;
        if (nombre != null) {
            prendas = prendaService.findByName(nombre);
        } else {
            prendas = prendaService.findAll();
        }
        return new ResponseEntity<>(prendas, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> findById(@PathVariable Long codigo){
        PrendaDto prenda = prendaService.findById(codigo);
        if(prenda == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prenda, HttpStatus.OK);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<?> update(@PathVariable Long codigo, @RequestBody PrendaDto prendaDto){
        PrendaDto updated = prendaService.update(codigo, prendaDto);
        if(updated == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> delete(@PathVariable Long codigo){
        Boolean deleted = prendaService.delete(codigo);
        if(!deleted){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
