package org.example.ej_joyeria.controller;

import org.example.ej_joyeria.model.Jewelry;
import org.example.ej_joyeria.service.JewelryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class Controller {

    private final JewelryServiceImpl service;

    public Controller(JewelryServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveJewelry(@RequestBody Jewelry jewelry) {
        service.addJewelry(jewelry);
        return new ResponseEntity<>(("Joya creada correctamente nro Identificatorio: " + jewelry.getId()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Jewelry>> getJewelry() {
        return new ResponseEntity<>(service.getJewelry(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewelry(@PathVariable Long id) {
        service.deleteJewelry(id);
        return new ResponseEntity<>("Joya eliminada correctamente", HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateJewelry(@PathVariable Long id, @RequestBody Jewelry jewelry) {
        service.updateJewelry(id, jewelry);
        return new ResponseEntity<>(jewelry, HttpStatus.OK);

    }


}
