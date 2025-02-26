package com.pruebaa.pruebademo.controller;

import com.pruebaa.pruebademo.model.ObraLiteraria;
import com.pruebaa.pruebademo.service.IObrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObrasController {

    @Autowired
    public IObrasService obrasService;

    @GetMapping("/all")
    public List<ObraLiteraria> getAll(){
        return obrasService.findAll();
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveObra(@RequestBody ObraLiteraria obraLiteraria){
        return new ResponseEntity<>(obrasService.saveObra(obraLiteraria),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteObra(@PathVariable String id){
        obrasService.deleteObra(id);
        return "Obra eliminada";
    }

    @GetMapping("/{id}")
    ResponseEntity<ObraLiteraria> findObraById(@PathVariable String id){
        return new ResponseEntity<>(obrasService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/{autor}")
    ResponseEntity<ObraLiteraria> findObraByIdAndAutor(@PathVariable String id,
                                                       @PathVariable String autor){
        return new ResponseEntity<>(obrasService.findByIdAndAuthor(id, autor), HttpStatus.OK);
    }
}