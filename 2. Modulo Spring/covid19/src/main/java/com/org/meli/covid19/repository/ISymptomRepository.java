package com.org.meli.covid19.repository;

import com.org.meli.covid19.entity.Symptom;

import java.util.List;

public interface ISymptomRepository {
    List<Symptom> findAll();
    List<Symptom> findByName(String name);
}
