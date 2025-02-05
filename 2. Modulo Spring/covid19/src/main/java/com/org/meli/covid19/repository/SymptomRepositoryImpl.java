package com.org.meli.covid19.repository;

import com.org.meli.covid19.entity.Symptom;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SymptomRepositoryImpl implements ISymptomRepository {
     private List<Symptom> symptoms = List.of(
            new Symptom(1, "Fiebre", 2),
            new Symptom(2, "Tos seca", 2),
            new Symptom(3, "Cansancio", 1),
            new Symptom(4, "Dolor de garganta", 1),
            new Symptom(5, "Diarrea", 1),
            new Symptom(6, "Dolor de cabeza", 1),
            new Symptom(7, "Pérdida del olfato", 2),
            new Symptom(8, "Pérdida del gusto", 2),
            new Symptom(9, "Erupciones cutáneas", 1),
            new Symptom(10, "Dificultad para respirar", 3)
    );

    @Override
    public List<Symptom> findAll() {
        return symptoms;
    }

    @Override
    public List<Symptom> findByName(String name) {
        return symptoms.stream()
                .filter(symptom -> symptom.getName().equalsIgnoreCase(name))
                .toList();
    }
}
