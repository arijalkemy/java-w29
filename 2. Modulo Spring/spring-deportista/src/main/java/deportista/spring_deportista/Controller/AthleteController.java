package deportista.spring_deportista.Controller;

import deportista.spring_deportista.Repository.Iservice;
import deportista.spring_deportista.Repository.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AthleteController {
    private final Iservice myService= new Service();

    public AthleteController() {
    }

    @GetMapping("/findSports")
    public ResponseEntity<?> findSport(){

        return new ResponseEntity<>(myService.getAllSports(),HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name){
        return new ResponseEntity<>(myService.findSPort(name),HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons(){
        return new ResponseEntity<>(myService.getAthletes(),HttpStatus.OK);
    }
}
