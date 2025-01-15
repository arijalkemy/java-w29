package com.example.demo.service;

import com.example.demo.model.Ingrediente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IIngredienteService {
    Map<List<Ingrediente>, Double> calcularCaloriasPorIngrediente(Ingrediente ingrediente, double gramos);
    Ingrediente obtenerIngredienteMasCalorico();
}
