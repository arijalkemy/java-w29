package org.melibootcamp.bonusej1.controller;

import jakarta.validation.Valid;
import org.melibootcamp.bonusej1.dto.GarmentDto;
import org.melibootcamp.bonusej1.dto.MessageDto;
import org.melibootcamp.bonusej1.service.IGarmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.namespace.QName;
import java.util.List;

@RestController("/api")
public class GarmentController {
    @Autowired
    IGarmentService service;
    @PostMapping("/clothes")
    public ResponseEntity<MessageDto> postGarment(@RequestBody @Valid GarmentDto garmentDto){
        return new ResponseEntity<MessageDto>(service.saveGarment(garmentDto), HttpStatus.OK);
    }
    @PutMapping("/clothes/{id}")
    public ResponseEntity<MessageDto> putGarment(@RequestBody @Valid GarmentDto garmentDto, @PathVariable Long id){
        return new ResponseEntity<MessageDto>(service.updateGarment(garmentDto,id), HttpStatus.OK);
    }
    @DeleteMapping("/clothes/{id}")
    public ResponseEntity<MessageDto> delGarment(@PathVariable Long id){
        return new ResponseEntity<MessageDto>(service.deleteGarmentById(id), HttpStatus.OK);
    }
    @GetMapping("/clothes")
    public ResponseEntity<List<GarmentDto>> searchGarments(){
        return new ResponseEntity<List<GarmentDto>>(service.getAllGarments(), HttpStatus.OK);
    }
    @GetMapping("/clothes/{id}")
    public ResponseEntity<GarmentDto> searchGarment(@PathVariable Long id){
        return new ResponseEntity<GarmentDto>(service.getGarmentById(id), HttpStatus.OK);
    }
    @GetMapping("/clothes/{size}")
    public ResponseEntity<List<GarmentDto>> searchGarmentBySize(@PathVariable String size){
        return new ResponseEntity<List<GarmentDto>>(service.getPrendasBySize(size), HttpStatus.OK);
    }
    @GetMapping("/clothes/by")
    public ResponseEntity<List<GarmentDto>> searchGarmentByName(@RequestParam String name){
        return new ResponseEntity<>(service.getPrendasByNameContainingIgnoreCase(name),HttpStatus.OK);
    }
}
