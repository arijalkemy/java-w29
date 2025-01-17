package com.calculadora.calorias.service;

import com.calculadora.calorias.dto.response.PlatoDTO;
import com.calculadora.calorias.model.Ingrediente;
import com.calculadora.calorias.model.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService{
    private IngredienteServiceImpl ingredienteService;
    private PlatoServiceImpl platoService;

    @Autowired
    public CalculadoraServiceImpl(IngredienteServiceImpl ingredienteService, PlatoServiceImpl platoService) {
        this.ingredienteService = ingredienteService;
        this.platoService = platoService;
    }

    @Override
    public PlatoDTO calcularCalorias(String name, Double peso) {
        List<Ingrediente> ingredientes = new ArrayList<>();
        Ingrediente ingredienteMasCalorico = null;
        Double totalCalorias = (double) 0;
        Double maxCalorias = (double) 0;

        Optional<Plato> plato = platoService.findPlatoByName(name);
        if (plato.isEmpty()) {
            return null;
        }

        for (String ingredienteName : plato.get().getIngredientes()) {
            Ingrediente ingrediente = this.ingredienteService.getIngredienteByName(ingredienteName);

            Double caloriasPorIngrediente = (ingrediente.getCalories() * peso) / 100;
            totalCalorias += caloriasPorIngrediente;

            if (caloriasPorIngrediente > maxCalorias) {
                maxCalorias = caloriasPorIngrediente;
                ingredienteMasCalorico = ingrediente;
            }

            ingrediente.setCalories(caloriasPorIngrediente);
            ingredientes.add(ingrediente);
        }
        ingredientes.forEach(System.out::println);

        return new PlatoDTO(
                totalCalorias,
                ingredientes,
                ingredienteMasCalorico
        );
    }
}
