package com.bootcamp.covid.repository;

import com.bootcamp.covid.model.Symptom;

import java.util.List;
import java.util.Optional;

public interface ISymptomRepository {
    List<Symptom> findAll();

    Optional<Symptom> findByName(String name);
}
