package com.example.calorias.service;

import java.util.List;

public interface CalculadoraService {

    Integer getCalorias(String plato);

    List<String> getIngredientes(String plato);

}
