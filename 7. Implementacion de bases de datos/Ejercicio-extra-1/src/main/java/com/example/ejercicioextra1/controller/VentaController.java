package com.example.ejercicioextra1.controller;

import com.example.ejercicioextra1.dto.reponse.PostVentaResponseDto;
import com.example.ejercicioextra1.dto.request.PostVentaRequestDto;
import com.example.ejercicioextra1.service.venta.VentaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
@AllArgsConstructor
public class VentaController {

    private final VentaServiceImpl ventaService;

    @PostMapping
    public ResponseEntity<PostVentaResponseDto> postSale(@RequestBody PostVentaRequestDto postVentaRequestDto) {
        return new ResponseEntity<>(ventaService.save(postVentaRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getSale(@RequestParam(required = false, defaultValue = "") String fecha) {
        return new ResponseEntity<>(ventaService.findAll(fecha), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostVentaResponseDto> getSaleById(@PathVariable Long id) {
        return new ResponseEntity<>(ventaService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSaleById(@PathVariable Long id) {
        ventaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("clothes/{id}")
    public ResponseEntity<?> getPrendasForVenta(@PathVariable Long id) {
        return new ResponseEntity<>(ventaService.getPrendasForVenta(id), HttpStatus.OK);
    }

}
