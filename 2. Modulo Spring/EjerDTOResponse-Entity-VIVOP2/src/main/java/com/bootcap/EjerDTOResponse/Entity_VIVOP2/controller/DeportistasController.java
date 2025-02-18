package com.bootcap.EjerDTOResponse.Entity_VIVOP2.controller;

import com.bootcap.EjerDTOResponse.Entity_VIVOP2.model.Deporte;
import com.bootcap.EjerDTOResponse.Entity_VIVOP2.model.Persona;
import com.bootcap.EjerDTOResponse.Entity_VIVOP2.model.dto.Atleta;
import com.bootcap.EjerDTOResponse.Entity_VIVOP2.service.DeportistasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {

    //Ver todos los deportes cargados.
    @GetMapping("/findSport")
    public ResponseEntity<List<Deporte>> deportes(){
        return ResponseEntity.ok(DeportistasService.getDeportes());
    }

    //Consultar si existe un deporte ingresando su nombre. De existir, se deberá mostrar el nivel del mismo.
    // Utilizar la clase ResponseEntity para devolver la respuesta.
    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> buscarPorNombre(@PathVariable String name){
        return ResponseEntity.ok(DeportistasService.buscarDeporte(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<Atleta>> buscarDeportePersona(){
        return ResponseEntity.ok(DeportistasService.buscarPersonasDeportista());
    }

}
