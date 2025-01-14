package exercise.starwars.controller;

import exercise.starwars.dto.response.CharacterResponseDto;
import exercise.starwars.service.ICharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/characters")
@RestController
public class CharacterController {
    private final ICharacterService characterService;

    public CharacterController(ICharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterResponseDto>> getCharactersByName(@PathVariable String name) {
        return ResponseEntity.ok(characterService.getCharactersByName(name));
    }

}
