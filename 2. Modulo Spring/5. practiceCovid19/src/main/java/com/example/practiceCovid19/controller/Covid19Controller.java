package com.example.practiceCovid19.controller;

import com.example.practiceCovid19.model.Person;
import com.example.practiceCovid19.model.RiskPersonDTO;
import com.example.practiceCovid19.model.Symptom;
import com.example.practiceCovid19.repository.PersonService;
import com.example.practiceCovid19.repository.SymptomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Covid19Controller {
    private SymptomService symptomService;
    private PersonService personService;

    public Covid19Controller() {
        symptomService = new SymptomService();
        personService = new PersonService();
        symptomService.addSymptom(new Symptom(1L, "Fever", 3));
        symptomService.addSymptom(new Symptom(2L, "Cough", 5));
        symptomService.addSymptom(new Symptom(3L, "Headache", 1));
        personService.addPerson(new Person(1L, "Pepito", "Perez", 40));
        personService.addPerson(new Person(2L, "Juanita", "Lopes", 70));
        personService.addPerson(new Person(3L, "Manolo", "Mendez", 61));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<?> getAllSymptoms() {
        return new ResponseEntity<>(symptomService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> getSymptomByName(@PathVariable String name) {
        return new ResponseEntity<>("Nivel de Gravedad: " + symptomService.getSymptomByName(name).getSeverity(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> getRiskPeople() {
        List<Person> personList = personService.getAll();
        List<Symptom> symptomList = symptomService.getAll();

        List<RiskPersonDTO> riskPersonDTO = new ArrayList<>();
        personList.forEach(person -> {
            if (person.getAge() > 60) {
                riskPersonDTO.add(new RiskPersonDTO(person.getName(), person.getLastname(), symptomList));
            }
        });

        return new ResponseEntity<>(riskPersonDTO, HttpStatus.OK);
    }
}
