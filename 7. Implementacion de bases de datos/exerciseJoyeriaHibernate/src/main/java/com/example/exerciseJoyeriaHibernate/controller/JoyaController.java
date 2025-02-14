package com.example.exerciseJoyeriaHibernate.controller;

import com.example.exerciseJoyeriaHibernate.dto.JoyaNroIdentificatorioResponseDto;
import com.example.exerciseJoyeriaHibernate.dto.JoyaRequestDto;
import com.example.exerciseJoyeriaHibernate.dto.JoyaResponseDto;
import com.example.exerciseJoyeriaHibernate.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<JoyaNroIdentificatorioResponseDto> postNewJoya(@RequestBody JoyaRequestDto joyaRequestDto){
        return new ResponseEntity<>(joyaService.addJoya(joyaRequestDto), HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JoyaResponseDto>> postNewJoya(){
        return new ResponseEntity<>(joyaService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> postNewJoya(@PathVariable Long id){
        joyaService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/jewerly/update/{id}")
    public ResponseEntity<JoyaResponseDto> postUpdateJoya(@PathVariable Long id, @RequestBody JoyaRequestDto joyaRequestDto){
        return new ResponseEntity<>(joyaService.postUpdateJoya(id, joyaRequestDto), HttpStatus.OK);
    }

        @GetMapping("/jewerly/list")
    public ResponseEntity<List<JoyaResponseDto>> getJojasIsVenta(){
        return new ResponseEntity<>(joyaService.findJoyaIsVenta(), HttpStatus.OK);
    }
}
