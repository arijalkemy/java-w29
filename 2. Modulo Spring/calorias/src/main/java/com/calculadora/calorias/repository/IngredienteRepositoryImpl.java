package com.calculadora.calorias.repository;

import com.calculadora.calorias.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class IngredienteRepositoryImpl implements IIngredienteRepository{
    private List<Ingrediente> ingredientes;

    public IngredienteRepositoryImpl() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("food.json");
            ObjectMapper mapper = new ObjectMapper();
            if (inputStream != null) {
                ingredientes = mapper.readValue(inputStream, new TypeReference<List<Ingrediente>>() {});
            } else {
                throw new FileNotFoundException("Archivo no encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ingrediente> findAll() {
        return ingredientes;
    }

    @Override
    public Ingrediente getIngredienteByName(String name) {
        return this.ingredientes.stream().filter(ingrediente -> ingrediente.getName().equals(name)).findFirst().orElse(null);
    }
}
