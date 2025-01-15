package com.mercadolibre.javawave29.covid_19.repository;

import com.mercadolibre.javawave29.covid_19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SymptomRepository {

    private List<Symptom> symptoms = List.of(
            new Symptom("Headache", 5),
            new Symptom("Cough", 3),
            new Symptom("Fever", 7),
            new Symptom("Sore Throat", 4),
            new Symptom("Fatigue", 6),
            new Symptom("Nausea", 5),
            new Symptom("Dizziness", 4),
            new Symptom("Shortness of Breath", 8),
            new Symptom("Chest Pain", 9),
            new Symptom("Loss of Smell", 2)
    );

    public List<Symptom> findAll() {
        return symptoms;
    }

    public Optional<Symptom> findById(String name) {
        return symptoms
                .stream()
                .filter(symptom -> symptom.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
