package com.example.practiceCovid19.repository;

import com.example.practiceCovid19.model.Symptom;
import com.example.practiceCovid19.model.interfaces.ISymptom;

import java.util.ArrayList;
import java.util.List;

public class SymptomRepository implements ISymptom {
    List<Symptom> symptoms = new ArrayList<>();

    @Override
    public void addSymptom(Symptom symptom) {
        symptoms.add(symptom);
    }

    @Override
    public List<Symptom> getAll() {
        return symptoms;
    }

    @Override
    public Symptom getSymptomByName(String name) {
        return symptoms.stream()
                .filter(symptom -> symptom.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
