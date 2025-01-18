package dev.deportistas.controller;

import dev.deportistas.service.DeportistasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deportistas")
public class DeportistasController {

    private final DeportistasService sportService;

    public DeportistasController(DeportistasService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports(){
        try{
            return ResponseEntity.ok(sportService.allSports());
        }catch(IllegalArgumentException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/findSports/{nameSport}")
    public ResponseEntity<?> findSportsByName(@PathVariable String nameSport){
        try{
            return ResponseEntity.ok(sportService.sportByName(nameSport));
        }catch(IllegalArgumentException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons(){
        try{
            return ResponseEntity.ok(sportService.getPersonsBySport());
        }catch(IllegalArgumentException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
