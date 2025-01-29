package multicapa_1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import multicapa_1.services.ICharactersService;

@RequiredArgsConstructor
@RestController
public class CharactersController {
  private final ICharactersService charactersService;

  @GetMapping("/characters")
  public ResponseEntity<?> getCharacters(@RequestParam("name") String name) {
    return new ResponseEntity<>(charactersService.findByName(name), HttpStatus.OK);
  }

}
