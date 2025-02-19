package com.meli.Showroom.controller;

import com.meli.Showroom.dto.PrendaDto;
import com.meli.Showroom.dto.VentaDto;
import com.meli.Showroom.service.IVentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
public class VentaController {

    private final IVentaService ventaService;

    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody VentaDto ventaDto){
        return ResponseEntity.ok(ventaService.save(ventaDto));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(ventaService.searchAll());
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> getPrendasByVentaNumero(@PathVariable("number") Integer numero) {
        return ResponseEntity.ok(ventaService.getPrendasByVentaNumero(numero));
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> findByNumber(@PathVariable Integer number){
        return ResponseEntity.ok(ventaService.searchByNumer(number));
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> delete(@RequestBody VentaDto ventaDto, @PathVariable Integer number){
        return ResponseEntity.ok(ventaService.modify(number, ventaDto));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> delete(@PathVariable Integer number){
        return ResponseEntity.ok(ventaService.delete(number));
    }
}
