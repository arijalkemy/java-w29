package com.org.meli.joyeria.controller;

import com.org.meli.joyeria.dto.JoyaDTO;
import com.org.meli.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<String> createJoya(@RequestBody JoyaDTO joyaDTO) {
        JoyaDTO newJoya = joyaService.createJoya(joyaDTO);
        return new ResponseEntity<>("Joya created with ID: " + newJoya.getNroIdentificatorio(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<JoyaDTO>> getAllJoyas() {
        List<JoyaDTO> joyas = joyaService.getAllJoyas();
        return new ResponseEntity<>(joyas, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JoyaDTO> deleteJoya(@PathVariable Long id) {
        JoyaDTO deletedJoya = joyaService.deleteJoya(id);
        return new ResponseEntity<>(deletedJoya, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaDTO> updateJoya(@PathVariable Long id, @RequestBody JoyaDTO joyaDTO) {
        JoyaDTO updatedJoya = joyaService.updateJoya(id, joyaDTO);
        return new ResponseEntity<>(updatedJoya, HttpStatus.OK);
    }
}