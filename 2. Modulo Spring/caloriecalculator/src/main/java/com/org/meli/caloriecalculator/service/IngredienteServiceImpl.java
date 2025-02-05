package com.org.meli.caloriecalculator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.meli.caloriecalculator.dto.IngredienteDto;
import com.org.meli.caloriecalculator.entity.Ingrediente;
import com.org.meli.caloriecalculator.repository.IIngredienteRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredienteServiceImpl implements IIngredienteService {
    private final IIngredienteRepository ingredienteRepository;

    public IngredienteServiceImpl(IIngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }
}
