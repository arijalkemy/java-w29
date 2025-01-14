package com.example.practiceCovid19.repository;

import com.example.practiceCovid19.model.Symptom;

import java.util.List;

public class SymptomService {
    private SymptomRepository symptomRepository;

    public SymptomService() {
        this.symptomRepository = new SymptomRepository();
    }

    public void addSymptom(Symptom symptom){
        this.symptomRepository.addSymptom(symptom);
    }

    public List<Symptom> getAll(){
        return this.symptomRepository.getAll();
    }

    public Symptom getSymptomByName(String name){
        return symptomRepository.getSymptomByName(name);
    }
}
