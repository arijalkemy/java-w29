package com.example.covid.repositories;

import com.example.covid.entity.Persona;

import java.util.List;

public interface IPersonaRepository {
    public List<Persona> findRiskPerson();
}
