package com.example.demo.controller;


import com.example.demo.dto.ObraLiterariaDto;
import com.example.demo.dto.response.ApiResponseDto;
import com.example.demo.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ObraLiterariaController {

    @Autowired
    private IObraLiterariaService obraLiterariaService;

    @PostMapping("/libros")
    public ResponseEntity<ApiResponseDto> postObra(@RequestBody ObraLiterariaDto obra){
        return new ResponseEntity<>(obraLiterariaService.saveObra(obra), HttpStatus.CREATED);
    }

    @GetMapping("/libros")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasByAutor(@RequestParam String autor){
        return new ResponseEntity<>(obraLiterariaService.searchObrasByAutor(autor),HttpStatus.OK);
    }

    @GetMapping("/libros")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasByKeyword(@RequestParam String keyword){
        return new ResponseEntity<>(obraLiterariaService.searchObrasByKeyWord(keyword),HttpStatus.OK);
    }

    @GetMapping("/libros/top")
    public ResponseEntity<List<ObraLiterariaDto>> getTopObrasAndOrderDesc(){
        return new ResponseEntity<>(obraLiterariaService.searchTopObrasAndOrderDesc(),HttpStatus.OK);
    }

    @GetMapping("/libro")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasByDate(@RequestParam Date fecha){
        return new ResponseEntity<>(obraLiterariaService.searchByDate(fecha),HttpStatus.OK);
    }

    @GetMapping("/libro")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasByEditorial(@RequestParam String fecha){
        return new ResponseEntity<>(obraLiterariaService.searchByEditorial(fecha),HttpStatus.OK);
    }
}
