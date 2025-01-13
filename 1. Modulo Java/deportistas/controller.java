package com.example.demo.deportistas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class controller {
    Deporte d1 = new Deporte(3, "Futbol");
    Deporte d2 = new Deporte(6, "Basket");
    Deporte d3 = new Deporte(9, "Tenis");
    Deporte[] deportes =  new Deporte[]{d1, d2, d3};


    @GetMapping("/findSports")
    public ResponseEntity<Deporte[]> getAll() {
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("findSports/{sport}")
    public ResponseEntity<Deporte> getBySport(@PathVariable String sport) {

        for (Deporte d : deportes){
            if(d.getNombre().equals(sport)){
                return new ResponseEntity<>(d,HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(new Deporte(0, "Not found"), HttpStatus.NOT_FOUND);
    }

    Persona p1 = new Persona("Nombre 1", "Apellido", 20, d1);
    Persona p2 = new Persona("Nombre 2 ", "Apellido 2", 21, d2);
    Persona p3 = new Persona("Nombre 3", "Apellido 3", 23, d3);
    Persona[] personas = new Persona[]{p1, p2, p3};

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        List<DeportistaDTO> dtos = new ArrayList<>();
        for(Persona d: personas){
            dtos.add(new DeportistaDTO(d.getNombre(), d.getApellido(), d.getDeporte().getNombre()) );
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
