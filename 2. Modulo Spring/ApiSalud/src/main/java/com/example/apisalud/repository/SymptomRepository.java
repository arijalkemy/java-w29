package com.example.apisalud.repository;

import com.example.apisalud.model.entity.Symptom;
import com.example.apisalud.repository.interfaces.IReadeable;
import java.util.List;

public class SymptomRepository implements IReadeable<Symptom> {
    private final List<Symptom> symptoms = List.of(
            Symptom.builder().code("S1").name("Fiebre").severity(1).build(),
            Symptom.builder().code("S2").name("Tos").severity(2).build(),
            Symptom.builder().code("S3").name("Dolor de cabeza").severity(3).build(),
            Symptom.builder().code("S4").name("Dolor de garganta").severity(4).build(),
            Symptom.builder().code("S5").name("Dolor de cuerpo").severity(5).build()
    );

    @Override
    public List<Symptom> getAll() {
        return symptoms;
    }

    public Symptom getByName(String name) {
        return symptoms.stream().filter(symptom -> symptom.getName().equals(name)).findFirst().orElse(null);
    }
}
