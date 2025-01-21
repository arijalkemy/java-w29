package Controller;

import DTO.PersonaDTO;
import Model.Deporte;
import Model.Persona;
import Service.DeporteService;
import Service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sports/")
public class DeporteController {

    PersonaService personService = new PersonaService();
    DeporteService sportService = new DeporteService();

    @GetMapping("findSports")
    public ResponseEntity<List<Deporte>> getAllSports(String param) {
        List<Deporte> sports = sportService.getAllSports();
        return new ResponseEntity<List<Deporte>>(sports, HttpStatus.OK);
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<Deporte> getSport(@PathVariable String name) {
        Deporte sport = sportService.getSportByName(name);
        if (sport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Deporte>(sport,HttpStatus.OK);
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> getSportPeople(String param) {
        List<PersonaDTO> people = personService.getAllPeople();
        return new ResponseEntity<List<PersonaDTO>>(people,HttpStatus.OK);
    }

    /*@PostMapping("addPerson")
    public ResponseEntity<String> createPerson(@RequestBody Persona person) {
        //TODO: process POST request
        personService.add(person);
        return new ResponseEntity<>("SE HA CREADO CORRECTAMENTE",HttpStatus.OK);
    }*/

}
