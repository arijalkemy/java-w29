package com.example.__persona.controller;

import com.example.__persona.dto_out.DeporteDTO_Out;
import com.example.__persona.dto_out.DeporteNivelDTO_Out;
import com.example.__persona.dto_out.PersonaDeporteDTO_Out;
import com.example.__persona.model.Deporte;
import com.example.__persona.model.Persona;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sport")
public class DeporteController {
    private List<Deporte> deportes;
    private List<Persona> personas;

    public DeporteController(){
        this.deportes = new ArrayList<>(List.of(
                new Deporte("Football", 1),
                new Deporte("Football", 2),
                new Deporte("Handball", 1)
        ));

        this.personas = new ArrayList<>(List.of(
                new Persona("Eliana", "Navarro", 26, null),
                new Persona("Lara", "Navarro", 17, this.deportes.get(0)),
                new Persona("Milu", "Navarro", 11, this.deportes.get(2))
        ));
    }
    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO_Out>> getAll(){
        List<DeporteDTO_Out> listado = deportes.stream()
                .map(DeporteDTO_Out::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/findSports/{nombre}")
    public ResponseEntity<List<DeporteNivelDTO_Out>> getByName(
            @PathVariable String nombre
    ){
        List<DeporteNivelDTO_Out> listado = deportes.stream()
                .filter(d -> d.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .map(DeporteNivelDTO_Out::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/findSportPersons")
    public ResponseEntity<List<PersonaDeporteDTO_Out>> getSportPerson(){
        List<PersonaDeporteDTO_Out> listado = this.personas.stream()
                .filter(p -> p.getDeporte() != null)
                .map(PersonaDeporteDTO_Out::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }
}
