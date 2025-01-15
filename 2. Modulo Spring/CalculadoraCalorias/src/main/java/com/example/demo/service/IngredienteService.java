package com.example.demo.service;

import com.example.demo.model.Ingrediente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class IngredienteService implements IIngredienteService{
    private final IngredienteRepository ingredienteRepository;
    @Override
    public Map<List<Ingrediente>, Double> calcularCaloriasPorIngrediente(Ingrediente ingrediente, double gramos) {
        return Map.of();
    }

    @Override
    public Ingrediente obtenerIngredienteMasCalorico() {
        return null;
    }
}
