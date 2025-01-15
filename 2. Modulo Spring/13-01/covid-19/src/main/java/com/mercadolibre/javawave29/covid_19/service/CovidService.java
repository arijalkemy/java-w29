package com.mercadolibre.javawave29.covid_19.service;

import com.mercadolibre.javawave29.covid_19.model.RiskPersonDTO;
import com.mercadolibre.javawave29.covid_19.model.Symptom;
import com.mercadolibre.javawave29.covid_19.model.SymptomDTO;
import com.mercadolibre.javawave29.covid_19.repository.PersonRepository;
import com.mercadolibre.javawave29.covid_19.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CovidService {

    private final PersonRepository personRepository;
    private final SymptomRepository symptomRepository;

    @Autowired
    public CovidService(PersonRepository personRepository, SymptomRepository symptomRepository) {
        this.personRepository = personRepository;
        this.symptomRepository = symptomRepository;
    }

    public List<Symptom> findSymptoms() {
        return symptomRepository.findAll();
    }

    public SymptomDTO findSymptomByName(String name) {
         Optional<Symptom> symptom = symptomRepository.findById(name);
        return symptom.map(value -> new SymptomDTO(value.getSeverityLevel())).orElse(null);
    }

    public List<RiskPersonDTO> findRiskPeople() {
        return List.of();
    }
}
