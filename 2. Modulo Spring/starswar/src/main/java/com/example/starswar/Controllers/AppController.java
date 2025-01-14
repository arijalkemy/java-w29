package com.example.starswar.Controllers;

import com.example.starswar.DTO.CharacterDTO;
import com.example.starswar.Services.AppService;
import com.example.starswar.Services.IAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    private IAppService appService;
    /// Inyección de dependencias.
    public AppController(IAppService appService) {
        this.appService = appService;
    }

    @GetMapping("/ObtainsCharacter/{name}")
    public ResponseEntity<List<CharacterDTO>> obtainCharacter(@PathVariable String name){
        List<CharacterDTO> charactersList = appService.getCharacterWithName(name);
        if (!charactersList.isEmpty()){
            return new ResponseEntity<>(charactersList, HttpStatus.OK);
        }
        return new ResponseEntity<>(charactersList,HttpStatus.CONFLICT);
    }
}
