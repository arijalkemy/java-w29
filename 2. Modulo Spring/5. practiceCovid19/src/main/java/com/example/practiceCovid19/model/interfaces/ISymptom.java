package com.example.practiceCovid19.model.interfaces;

import com.example.practiceCovid19.model.Symptom;

import java.util.List;

public interface ISymptom {
    void addSymptom(Symptom symptom);
    List<Symptom> getAll();
    Symptom getSymptomByName(String name);
}
