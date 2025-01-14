package org.example.dto_responseentity_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salud")
public class SaludController {

    @Autowired
    private SaludService saludService;

    @GetMapping("/findSymptom")
    public List<Sintoma> getAllSintomas() {
        return saludService.getAllSymptoms();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSintomaByName(@PathVariable String name) {
        return saludService.findSintomasByName(name);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> findRiskPersons() {
        return saludService.findRiskPersons();
    }

}
