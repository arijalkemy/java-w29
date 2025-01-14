package com.example.deportistas.controller;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import com.example.deportistas.service.DeportistasService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class DeportistasController {
    private DeportistasService deportistasService;

    //Ver los deportes cargados
    @GetMapping("findSports")
    public ResponseEntity<List<Deporte>> buscarDeportes(){
        return ResponseEntity.ok(deportistasService.getDeportes());
    }


    @GetMapping("findSport/{name}")
    public ResponseEntity<Deporte> buscarPorNombre(@PathVariable String name){
        return ResponseEntity.ok(deportistasService.buscarDeporte(name));
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<Persona>> buscarSportsPersons(){
        return ResponseEntity.ok(deportistasService.buscarPersonasDeportista());
    }

}
