package com.meli.Showroom.controller;

import com.meli.Showroom.dto.PrendaDto;
import com.meli.Showroom.service.IPrendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    private final IPrendaService prendaService;

    public PrendaController(IPrendaService prendaService) {
        this.prendaService = prendaService;
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody PrendaDto prendaDto){
        return ResponseEntity.ok(prendaService.save(prendaDto));
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(required = false) String name){
        return ResponseEntity.ok(prendaService.searchAll(name));
    }

    @GetMapping("byCode/{code}")
    public ResponseEntity<?> findByCode(@PathVariable Integer code){
        return ResponseEntity.ok(prendaService.searchByCode(code));
    }

    @GetMapping("byTalla/{talla}")
    public ResponseEntity<?> findByTalla(@PathVariable String talla){
        return ResponseEntity.ok(prendaService.searchByTalla(talla));
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> delete(@RequestBody PrendaDto prendaDto, @PathVariable Integer code){
        return ResponseEntity.ok(prendaService.modify(code, prendaDto));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable Integer code){
        return ResponseEntity.ok(prendaService.delete(code));
    }





}
