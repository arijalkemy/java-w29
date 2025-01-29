package com.example.EjercicioCovidBootcamp.Service;

import com.example.EjercicioCovidBootcamp.Entity.Sintoma;

import java.util.List;

public interface ISintomaSerivce {
    public List<String> findSymptom();
    public Sintoma findSymptomByName(String nombre);
}
