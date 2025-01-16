package dto_response_entity_p2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dto_response_entity_p2.entities.Sport;
import dto_response_entity_p2.repositories.Sports;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SportsController {
  private final Sports sports;
  
  @GetMapping("/findSports")
  ResponseEntity<List<Sport>> getSports(){
    return new ResponseEntity<List<Sport>>(sports.findAll(), HttpStatus.OK);
  }

  @GetMapping("/findSport/{name}")
  ResponseEntity<Optional<Sport>> getSportByName(@PathVariable("name") String name){
    return new ResponseEntity<Optional<Sport>>(sports.findByName(name), HttpStatus.OK);
  }
}
