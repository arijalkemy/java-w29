package dto_response_entity.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dto_response_entity.entities.Symptom;

@RestController
public class SymptomsController {
  
  @GetMapping("/findSymptom")
  ResponseEntity<List<Symptom>> getFindSymptom(){
    return ResponseEntity.noContent().build();
  }
}
