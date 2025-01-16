package dto_response_entity_p2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dto_response_entity_p2.services.PeopleSportsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class peopleController {
  private final PeopleSportsService peopleSportsService;
  
  @GetMapping("/findSportsPersons")
  ResponseEntity<?> getPeople(){
    return new ResponseEntity<>(
      peopleSportsService.getPeople(), 
      HttpStatus.OK
    );
  }
}
