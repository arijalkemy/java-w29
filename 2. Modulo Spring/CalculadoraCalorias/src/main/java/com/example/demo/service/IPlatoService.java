package com.example.demo.service;

import com.example.demo.model.Ingrediente;
import com.example.demo.model.Plato;

import java.util.List;
import java.util.Map;

public interface IPlatoService {
    double calcularCalorias(Plato plato, double gramos);
}
