package com.bootcamp.covid.repository;

import com.bootcamp.covid.model.RiskLevel;
import com.bootcamp.covid.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SymptomRepository implements ISymptomRepository{

    private final List<Symptom> symptoms = List.of(
            new Symptom(UUID.randomUUID().toString(), "Cough", RiskLevel.MILD),
            new Symptom(UUID.randomUUID().toString(), "Fever", RiskLevel.NORMAL),
            new Symptom(UUID.randomUUID().toString(), "headache", RiskLevel.SEVERE)
    );

    @Override
    public List<Symptom> findAll() {
        return List.copyOf(symptoms);
    }

    @Override
    public Optional<Symptom> findByName(String name) {
        return symptoms
                .stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
