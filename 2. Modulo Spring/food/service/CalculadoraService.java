package com.api.food.service;

import com.api.food.dto.CalculoResponseDTO;
import com.api.food.entity.Ingrediente;
import com.api.food.entity.Plato;
import com.api.food.repository.PlatoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CalculadoraService {
    private final IngredienteService ingredienteService;
    private final PlatoService platoService;

    public CalculadoraService(IngredienteService ingredienteService, PlatoService platoService) {
        this.ingredienteService = ingredienteService;
        this.platoService = platoService;
    }


    public CalculoResponseDTO calcularCalorias(String platoName, Integer pesoEnGr) {
        List<Ingrediente> ingredientes = new ArrayList<>();
        Plato plato = this.platoService.getPlatoByName(platoName);
        if(plato == null){ return null; }

        int totalCalorias = 0;
        Ingrediente ingredienteMayorCalorias = null;
        int maxCalorias = 0;

        for (String ingredienteName : plato.getIngredientes() ) { // nombre del ingrediente

            Ingrediente ingrediente = this.ingredienteService.getIngredienteByName(ingredienteName);

            int caloriasPorIngrediente = (ingrediente.getCalories() * pesoEnGr) / 100;
            totalCalorias += caloriasPorIngrediente;

            if (caloriasPorIngrediente > maxCalorias) {
                maxCalorias = caloriasPorIngrediente;
                ingredienteMayorCalorias = ingrediente;
            }

            ingrediente.setCalories(caloriasPorIngrediente);
            ingredientes.add(ingrediente);
        }
        ingredientes.forEach(System.out::println);

        return new CalculoResponseDTO(
                totalCalorias,
                ingredientes,
                ingredienteMayorCalorias
        );
    }

}
