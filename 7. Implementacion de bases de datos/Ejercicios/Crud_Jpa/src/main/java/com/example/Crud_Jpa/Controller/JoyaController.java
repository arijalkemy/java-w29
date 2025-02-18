package com.example.Crud_Jpa.Controller;

import com.example.Crud_Jpa.Model.Joya;
import com.example.Crud_Jpa.Service.IJoyaService;
import com.example.Crud_Jpa.Service.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("jewerly/")
public class JoyaController {
    @Autowired
    JoyaService service;

    @PostMapping("new")
        public ResponseEntity<?> saveJoya(@RequestBody Joya joya){

        return new ResponseEntity<>(service.saveJoya(joya).getNroIdentificatorio(), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateJoya(@RequestBody Joya joya, @PathVariable Long id){
        Joya joyaToUpdate = service.findJoya(id);
        joyaToUpdate.setNombre(joya.getNombre());
        joyaToUpdate.setMaterial(joya.getMaterial());
        joyaToUpdate.setPeso(joya.getPeso());
        joyaToUpdate.setParticularidad(joya.getParticularidad());
        joyaToUpdate.setPosee_piedra(joya.getPosee_piedra());
        joyaToUpdate.setVentaONO(joya.getVentaONO());

        Joya updatedJoya = service.saveJoya(joyaToUpdate);
        return new ResponseEntity<>(service.saveJoya(updatedJoya).getNroIdentificatorio(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> allJoyas(){

        return new ResponseEntity<>(service.getJoya(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getJoyas(@PathVariable Long id){

        return new ResponseEntity<>(service.findJoya(id),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteJoyas(@PathVariable Long id){
        service.deleteJoya(id);
        return new ResponseEntity<>("Borrado exitosamente",HttpStatus.OK);
    }

}
