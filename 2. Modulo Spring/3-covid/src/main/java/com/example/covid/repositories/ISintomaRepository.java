package com.example.covid.repositories;

import com.example.covid.entity.Sintoma;

import java.util.List;
import java.util.Optional;

public interface ISintomaRepository {
    public Optional<Sintoma> findSymptomByName(String sintoma);
    public List<Sintoma> findSymptom();
}
