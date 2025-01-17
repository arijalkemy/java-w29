package com.calculadora.calorias.service;

import com.calculadora.calorias.model.Ingrediente;
import com.calculadora.calorias.repository.IngredienteRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteServiceImpl implements IIngredienteService{
    private IngredienteRepositoryImpl ingredienteRepository;

    @Autowired
    public IngredienteServiceImpl(IngredienteRepositoryImpl ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public List<Ingrediente> findAll() {
        return this.ingredienteRepository.findAll();
    }

    @Override
    public Ingrediente getIngredienteByName(String name) {
        return this.ingredienteRepository.getIngredienteByName(name);
    }
}
