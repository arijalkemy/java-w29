package com.example.EjercicioCovidBootcamp.Repository;

import com.example.EjercicioCovidBootcamp.Entity.Sintoma;

import java.util.List;

public interface ISintomaRepository {
    public List<Sintoma> findSintomas();
}
