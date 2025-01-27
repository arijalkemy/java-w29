package com.bootcamp.excercise.repository;

import com.bootcamp.excercise.entity.Sintoma;

import java.util.List;

public interface SintomaRepository {
    List<Sintoma> findAllSymptoms();
    Sintoma findByName(String nombre);
}
