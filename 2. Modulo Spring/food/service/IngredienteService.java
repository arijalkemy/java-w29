package com.api.food.service;


import com.api.food.entity.Ingrediente;
import com.api.food.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {
    private final IngredienteRepository ingredienteRepository;


    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public Ingrediente getIngredienteByName(String name){
        return this.ingredienteRepository.getIngredienteByName(name);
    }
    public List<Ingrediente> getAll(){
        return this.ingredienteRepository.getIngredientes();
    }
}
