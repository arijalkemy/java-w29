package dto_response_entity.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dto_response_entity.services.BirthsService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class birthDate {
  private final BirthsService service;

  @GetMapping("/{day}/{month}/{year}")
  ResponseEntity<?> getBirthDate(
    @PathVariable("day") Integer day,
    @PathVariable("month") Integer month,
    @PathVariable("year") Integer year
  ){
    Integer age = service.getAge(day, month, year);
    return new ResponseEntity<>(age, HttpStatus.OK);
  }
}
