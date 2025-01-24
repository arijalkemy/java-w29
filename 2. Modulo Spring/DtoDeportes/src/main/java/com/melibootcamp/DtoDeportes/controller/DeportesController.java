package com.melibootcamp.DtoDeportes.controller;

import com.melibootcamp.DtoDeportes.dto.DtoSportPerson;
import com.melibootcamp.DtoDeportes.services.IPersonFind;
import com.melibootcamp.DtoDeportes.services.ISportFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeportesController {
    @Autowired
    IPersonFind personFind;
    @Autowired
    ISportFinder sportFinder;

    @GetMapping("/findSports")
    public ResponseEntity<String> findSports() {
        return ResponseEntity.ok("Los deportes guardados son: "+ sportFinder.findSports().toString()) ;
    }
    @GetMapping("findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {
        if (sportFinder.findSport(name) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("El deporte encontrado es: "+ sportFinder.findSport(name).toString());
    }
    @GetMapping("/findSportsPersons/{name}")
    public ResponseEntity<String> findSportsPersons(@PathVariable String name) {
        DtoSportPerson person = personFind.findSportPerson(name);
        if ( person== null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person.toString());
    }
}
